package net.nerddash.simpleauctionapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.nerddash.simpleauctionapi.dto.DTO;
import net.nerddash.simpleauctionapi.dto.RaceDTO;
import net.nerddash.simpleauctionapi.model.Race;
import net.nerddash.simpleauctionapi.repository.RaceRepository;

@Service
public class RaceService extends ApiServiceImpl<Race, RaceRepository> {

	@Override
	public RaceDTO entityToDto(Race race) {
		return new RaceDTO(race);
	}

	@Override
	public Page<? extends DTO<Race>> listAllDTO(Pageable pageable) {
		Page<Race> findAll = repository.findAll(pageable);
		return findAll.map(RaceDTO::new);
	}

}
