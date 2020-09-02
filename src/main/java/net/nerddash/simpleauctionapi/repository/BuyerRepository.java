package net.nerddash.simpleauctionapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.nerddash.simpleauctionapi.model.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Long>{

	Optional<Buyer> findByPhoneNumber(String phoneNumber);

}
