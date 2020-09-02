package net.nerddash.simpleauctionapi.dto;

import java.util.Date;

import net.nerddash.simpleauctionapi.model.Bid;

public class BidDTO extends DTO<Bid> {

	private Long id;

	private BatchDTO batch;

	private BuyerDTO buyer;

	private Long bidValue;

	private Date createdAt;

	public BidDTO(Bid bid) {
		super(bid);
		this.id = bid.getId();
		this.batch = new BatchDTO(bid.getBatch());
		this.buyer = new BuyerDTO(bid.getBuyer());
		this.bidValue = bid.getBidValue();
		this.createdAt = bid.getCreatedAt();
	}

	public Long getId() {
		return id;
	}

	public Long getBidValue() {
		return bidValue;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public BatchDTO getBatch() {
		return batch;
	}

	public BuyerDTO getBuyer() {
		return buyer;
	}

}
