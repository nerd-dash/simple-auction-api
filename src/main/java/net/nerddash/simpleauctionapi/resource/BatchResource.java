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
import net.nerddash.simpleauctionapi.service.AgeService;
import net.nerddash.simpleauctionapi.service.AuctionService;
import net.nerddash.simpleauctionapi.service.BatchService;
import net.nerddash.simpleauctionapi.service.RaceService;

@RestController
@RequestMapping("/batches")
public class BatchResource extends ApiResourceImpl<Batch, BatchForm, BatchService> {

	@Autowired
	AgeService ageService;

	@Autowired
	AuctionService auctionService;

	@Autowired
	RaceService raceService;

	@Override
	public Batch formToEntity(BatchForm form) throws Exception {

		Optional<Age> age = ageService.findById(form.getAge());
		Optional<Auction> auction = auctionService.findById(form.getAuction());
		Optional<Race> race = raceService.findById(form.getRace());

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