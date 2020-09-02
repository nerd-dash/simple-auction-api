package net.nerddash.simpleauctionapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.nerddash.simpleauctionapi.dto.AuctionDTO;
import net.nerddash.simpleauctionapi.dto.DTO;
import net.nerddash.simpleauctionapi.model.Auction;
import net.nerddash.simpleauctionapi.repository.AuctionRepository;

@Service
public class AuctionService extends ApiServiceImpl<Auction, AuctionRepository> implements ApiService<Auction> {

	@Override
	public AuctionDTO entityToDto(Auction entity) {
		return new AuctionDTO(entity);
	}

	@Override
	public Page<? extends DTO<Auction>> listAllDTO(Pageable pageable) {
		Page<Auction> findAll = repository.findAll(pageable);
		return findAll.map(AuctionDTO::new);
	}
	
	@Override
	public boolean shouldRead(Auction entity) {
		return true;
	}
	
	
}
