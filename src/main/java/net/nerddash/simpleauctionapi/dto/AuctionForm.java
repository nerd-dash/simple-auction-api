package net.nerddash.simpleauctionapi.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import net.nerddash.simpleauctionapi.model.Auction;

public class AuctionForm implements Form<Auction> {

	@NotNull
	@NotEmpty
	private String description;

	@Override
	public Auction toEntity() {
		return new Auction(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Auction updateEntity(Auction savedAuction) {

		if (savedAuction != null) {
			savedAuction.setDescription(description);
			savedAuction.setUpdatedAt(new Date());
		}

		return savedAuction;
	}

}
