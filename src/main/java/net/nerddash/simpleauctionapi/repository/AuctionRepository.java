package net.nerddash.simpleauctionapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.nerddash.simpleauctionapi.model.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

}
