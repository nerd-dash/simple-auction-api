package net.nerddash.simpleauctionapi.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import net.nerddash.simpleauctionapi.model.Batch;
import net.nerddash.simpleauctionapi.repository.BatchRepository;
import net.nerddash.simpleauctionapi.service.BatchService;
import net.nerddash.simpleauctionapi.service.StreamService;
import reactor.core.publisher.Flux;

@RestController
public class StreamResource {

    @Autowired
    private StreamService<Batch> reactiveBatchRepository;

    @Autowired
    private BatchService batchService;

    @GetMapping(path = "/batches/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Batch> batchFeed() {
        return this.reactiveBatchRepository.getFeed();
    }

    @PostMapping(path = "/batches/stream/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Batch> publishBatch(@PathVariable Long id) throws Exception {

        Optional<Batch> batchOptional = this.batchService.findById(id);

        if (batchOptional.isPresent()) {
            Batch batch = batchOptional.get();
            this.reactiveBatchRepository.publish(batch);
            return ResponseEntity.ok().body(batch);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}
