package net.nerddash.simpleauctionapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.nerddash.simpleauctionapi.model.Batch;

public interface BatchRepository extends JpaRepository<Batch, Long> {

}
