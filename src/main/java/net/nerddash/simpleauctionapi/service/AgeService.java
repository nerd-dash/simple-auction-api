package net.nerddash.simpleauctionapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.nerddash.simpleauctionapi.dto.AgeDTO;
import net.nerddash.simpleauctionapi.model.Age;
import net.nerddash.simpleauctionapi.repository.AgeRepository;

@Service
public class AgeService extends ApiServiceImpl<Age, AgeRepository>{

	@Override
	public Page<AgeDTO> listAllDTO(Pageable pageable) {
		Page<Age> ages = repository.findAll(pageable);
		return ages.map(AgeDTO::new);
	}

	@Override
	public AgeDTO entityToDto(Age age) {
		return new AgeDTO(age);
	}
	
	@Override
	public boolean shouldRead(Age entity) {
		return true;
	}
	
	@Override
	public boolean shouldUpdate(Age entity) {
		return false;
	}

}
