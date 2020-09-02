package net.nerddash.simpleauctionapi.dto;

import net.nerddash.simpleauctionapi.model.ApiEntity;

public class GenericForm<E extends ApiEntity> implements Form<E> {

	@Override
	public E toEntity() {
		return null;
	}
	
	@Override
	public E updateEntity(E entity) {
		return null;
	}

}
