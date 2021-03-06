package net.nerddash.simpleauctionapi.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import net.nerddash.simpleauctionapi.dto.BidForm;
import net.nerddash.simpleauctionapi.model.Batch;
import net.nerddash.simpleauctionapi.model.Bid;
import net.nerddash.simpleauctionapi.model.Buyer;
import net.nerddash.simpleauctionapi.service.BatchService;
import net.nerddash.simpleauctionapi.service.BidService;
import net.nerddash.simpleauctionapi.service.BuyerService;

@RestController
@RequestMapping("/bids")
public class BidResource extends ApiResourceImpl<Bid, BidForm, BidService> {

	@Autowired
	BatchService batchService;

	@Autowired
	BuyerService buyerService;

	@Override
	public Bid formToEntity(BidForm form) {

		Optional<Batch> batch = batchService.findById(form.getBatch());
		Optional<Buyer> buyer = buyerService.findById(form.getBuyer());

		if (batch.isPresent() && buyer.isPresent()) {

			Bid entity = form.toEntity();
			entity.setBatch(batch.get());
			entity.setBuyer(buyer.get());
			return entity;
		}

		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	}
}