package net.nerddash.simpleauctionapi.dto;

import java.util.Date;

import net.nerddash.simpleauctionapi.model.Auction;

public class AuctionDTO extends DTO<Auction> {

	private Long id;
	private String description;
	private Date createdAt;

	public AuctionDTO(Auction auction) {
		super(auction);
		this.id = auction.getId();
		this.description = auction.getDescription();
		this.createdAt = auction.getCreatedAt();
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Date getDate() {
		return createdAt;
	}
	
}
