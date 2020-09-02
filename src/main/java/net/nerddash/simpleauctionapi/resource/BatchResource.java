package net.nerddash.simpleauctionapi.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import net.nerddash.simpleauctionapi.dto.BatchForm;
import net.nerddash.simpleauctionapi.model.Age;
import net.nerddash.simpleauctionapi.model.Auction;
import net.nerddash.simpleauctionapi.model.Batch;
import net.nerddash.simpleauctionapi.model.Race;
import net.nerddash.simpleauctionapi.repository.AgeRepository;
import net.nerddash.simpleauctionapi.repository.AuctionRepository;
import net.nerddash.simpleauctionapi.repository.BatchRepository;
import net.nerddash.simpleauctionapi.repository.RaceRepository;
import net.nerddash.simpleauctionapi.service.BatchService;

@RestController
@RequestMapping("/batches")
public class BatchResource extends ApiResourceImpl<Batch, BatchForm, BatchRepository, BatchService>
		implements ApiResource<Batch, BatchForm> {

	@Autowired
	AgeRepository ageRepository;

	@Autowired
	AuctionRepository auctionRepository;

	@Autowired
	RaceRepository raceRepository;

	@Override
	public Batch formToEntity(BatchForm form) throws Exception {
		
		Optional<Age> age = ageRepository.findById(form.getAge());
		Optional<Auction> auction = auctionRepository.findById(form.getAuction());
		Optional<Race> race = raceRepository.findById(form.getRace());

		if (age.isPresent() && auction.isPresent() && race.isPresent()) {

			Batch entity = form.toEntity();
			entity.setAge(age.get());
			entity.setAuction(auction.get());
			entity.setRace(race.get());
			return entity;
		}
		
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	}
	
}