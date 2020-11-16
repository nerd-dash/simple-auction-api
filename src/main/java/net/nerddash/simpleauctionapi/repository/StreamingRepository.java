package net.nerddash.simpleauctionapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public class StreamingRepository<T> {

    protected List<T> streamList = new ArrayList<T>();
    protected T lastStream;

    public Flux<T> getLastStream() {
        return Flux.just(this.lastStream);
    }

    public void publishStream(T data) {
        this.lastStream = data;
        this.streamList.add(this.lastStream);

    }
}
