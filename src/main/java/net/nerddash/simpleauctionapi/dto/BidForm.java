package net.nerddash.simpleauctionapi.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import net.nerddash.simpleauctionapi.model.Bid;

public class BidForm implements Form<Bid>{
	
	@NotNull 
	private Long batch;

	@NotNull 
	private Long buyer;

	@NotNull @Min(value = 30)
	private Long bidValue;

	@Override
	public Bid toEntity() {
		return new Bid(bidValue);
	}

	public Long getBatch() {
		return batch;
	}

	public void setBatch(Long batch) {
		this.batch = batch;
	}

	public Long getBuyer() {
		return buyer;
	}

	public void setBuyer(Long buyer) {
		this.buyer = buyer;
	}

	public Long getBidValue() {
		return bidValue;
	}

	public void setBidValue(Long bidValue) {
		this.bidValue = bidValue;
	}

	@Override
	public Bid updateEntity(Bid savedEntity) {
		return null;
	}

}
