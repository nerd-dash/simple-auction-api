package net.nerddash.simpleauctionapi.dto;

import net.nerddash.simpleauctionapi.model.Batch;
import net.nerddash.simpleauctionapi.model.Sex;

public class BatchDTO extends DTO<Batch> {

	private Long id;

	private AuctionDTO auction;

	private RaceDTO race;

	private AgeDTO age;

	private Sex sex;

	private Integer quantity;

	private Long initialOffer;

	private Long targetOffer;

	private String videoLink;

	public BatchDTO(Batch batch) {
		super(batch);
		this.id = batch.getId();
		this.auction = new AuctionDTO(batch.getAuction());
		this.race = new RaceDTO(batch.getRace());
		this.age = new AgeDTO(batch.getAge());
		this.sex = batch.getSex();
		this.quantity = batch.getQuantity();
		this.initialOffer = batch.getInitialOffer();
		this.targetOffer = batch.getTargeOffer();
		this.videoLink = batch.getVideoLink();

	}

	public Long getId() {
		return id;
	}

	public Sex getSex() {
		return sex;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Long getInitialOffer() {
		return initialOffer;
	}

	public Long getTargetOffer() {
		return targetOffer;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public AuctionDTO getAuction() {
		return auction;
	}

	public RaceDTO getRace() {
		return race;
	}

	public AgeDTO getAge() {
		return age;
	}


}
