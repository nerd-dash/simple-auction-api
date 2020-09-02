package net.nerddash.simpleauctionapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.nerddash.simpleauctionapi.model.Race;

public interface RaceRepository extends JpaRepository<Race, Long> {

}
