package net.nerddash.simpleauctionapi.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import net.nerddash.simpleauctionapi.model.Batch;
import net.nerddash.simpleauctionapi.model.Sex;

public class BatchForm implements Form<Batch> {

	@NotNull
	private Long auction;

	@NotNull
	private Long race;

	@NotNull
	private Long age;

	@NotNull
	private Sex sex;

	@NotNull
	@Min(value = 1)
	private Integer quantity;

	@NotNull
	@Min(value = 30)
	private Long initialOffer;

	@NotNull
	@Min(value = 30)
	private Long targetOffer;

	@NotNull
	@NotEmpty
	@URL
	private String videoLink;

	@Override
	public Batch toEntity() {

		return new Batch(sex, quantity, initialOffer, targetOffer, videoLink);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getInitialOffer() {
		return initialOffer;
	}

	public void setInitialOffer(Long initialOffer) {
		this.initialOffer = initialOffer;
	}

	public Long getTargetOffer() {
		return targetOffer;
	}

	public void setTargetOffer(Long targetOffer) {
		this.targetOffer = targetOffer;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public Long getAuction() {
		return auction;
	}

	public void setAuction(Long auction) {
		this.auction = auction;
	}

	public Long getRace() {
		return race;
	}

	public void setRace(Long race) {
		this.race = race;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	@Override
	public Batch updateEntity(Batch savedBatch) {

		if (savedBatch != null) {
			savedBatch.setTargeOffer(targetOffer);
			savedBatch.setVideoLink(videoLink);
			savedBatch.setUpdatedAt(new Date());
		}
		
		return savedBatch;
	}

}
