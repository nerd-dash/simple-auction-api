package net.nerddash.simpleauctionapi.dto;

import net.nerddash.simpleauctionapi.model.ApiEntity;

public class DTO<E extends ApiEntity> {

	public DTO(E entity) {}
	
	DTO<E> entityToDto(E entity){
		return new DTO<E>(entity);
	}

}
