package net.nerddash.simpleauctionapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "batches")
public class Batch implements ApiEntity {

	public Batch() {}

	public Batch(@NotNull Sex sex, @NotNull Integer quantity, @NotNull Long initialOffer, Long targetOffer,
			@NotNull String videoLink) {
		super();
		this.sex = sex;
		this.quantity = quantity;
		this.initialOffer = initialOffer;
		this.targetOffer = targetOffer;
		this.videoLink = videoLink;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Auction auction;

	@ManyToOne
	private Race race;

	@ManyToOne
	private Age age;

	@NotNull
	@Enumerated
	private Sex sex;

	@NotNull
	private Integer quantity;

	@NotNull
	private Long initialOffer;

	private Long targetOffer;

	@NotNull @NotEmpty @URL
	private String videoLink;

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Age getAge() {
		return age;
	}

	public void setAge(Age age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
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

	public Long getTargeOffer() {
		return targetOffer;
	}

	public void setTargeOffer(Long targetOffer) {
		this.targetOffer = targetOffer;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Batch other = (Batch) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}