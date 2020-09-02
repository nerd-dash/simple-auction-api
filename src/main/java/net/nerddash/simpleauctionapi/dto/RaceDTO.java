package net.nerddash.simpleauctionapi.dto;

import net.nerddash.simpleauctionapi.model.Race;

public class RaceDTO extends DTO<Race> {

	private Long id;
	private String name;

	public RaceDTO(Race race) {
		super(race);
		this.id = race.getId();
		this.name = race.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
