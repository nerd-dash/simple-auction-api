package net.nerddash.simpleauctionapi.dto;

import net.nerddash.simpleauctionapi.model.Age;

public class AgeDTO extends DTO<Age> {
	
	private Long id;

	private Integer fromMonths;

	private Integer toMonths;

	public AgeDTO(Age age) {
		super(age);
		this.id = age.getId();
		this.fromMonths = age.getFromMonths();
		this.toMonths = age.getToMonths();
	}

	public Long getId() {
		return id;
	}

	public Integer getFromMonths() {
		return fromMonths;
	}

	public Integer getToMonths() {
		return toMonths;
	}

}
