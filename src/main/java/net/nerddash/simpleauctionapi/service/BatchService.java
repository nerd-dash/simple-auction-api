package net.nerddash.simpleauctionapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.nerddash.simpleauctionapi.dto.BatchDTO;
import net.nerddash.simpleauctionapi.dto.DTO;
import net.nerddash.simpleauctionapi.model.Batch;
import net.nerddash.simpleauctionapi.repository.BatchRepository;

@Service
public class BatchService extends ApiServiceImpl<Batch, BatchRepository> implements ApiService<Batch> {

	@Override
	public BatchDTO entityToDto(Batch batch) {
		return new BatchDTO(batch);
	}

	@Override
	public Page<? extends DTO<Batch>> listAllDTO(Pageable pageable) {
		Page<Batch> findAll = repository.findAll(pageable);
		return findAll.map(BatchDTO::new);
	}
}
