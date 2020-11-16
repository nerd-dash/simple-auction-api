package net.nerddash.simpleauctionapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.nerddash.simpleauctionapi.repository.StreamingRepository;
import reactor.core.publisher.Flux;

@Service
public class StreamService<T> {

    @Autowired
    private StreamingRepository<T> reactiveBatchRepository;

    public Flux<T> getFeed() {
        return this.reactiveBatchRepository.getLastStream();
    }

    public void publish(T data) {
        this.reactiveBatchRepository.publishStream(data);
    }

}
