package net.nerddash.simpleauctionapi.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.nerddash.simpleauctionapi.dto.AuctionForm;
import net.nerddash.simpleauctionapi.model.Auction;
import net.nerddash.simpleauctionapi.service.AuctionService;

@RestController
@RequestMapping("/auctions")
public class AuctionResource extends ApiResourceImpl<Auction, AuctionForm, AuctionService> {

}