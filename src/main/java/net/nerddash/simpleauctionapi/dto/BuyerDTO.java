package net.nerddash.simpleauctionapi.dto;

import java.util.Date;

import net.nerddash.simpleauctionapi.model.Buyer;

public class BuyerDTO extends DTO<Buyer> {

	private Long id;
	private String name;
	private String farmName;
	private Date createdAt;


	public BuyerDTO(Buyer buyer) {
		super(buyer);
		this.id = buyer.getId();
		this.name = buyer.getName();
		this.farmName = buyer.getFarmName();
		this.createdAt = buyer.getCreatedAt();

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFarmName() {
		return farmName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

}
