package net.nerddash.simpleauctionapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.nerddash.simpleauctionapi.model.Bid;

public interface BidRepository extends JpaRepository<Bid, Long> {

}
