package net.nerddash.simpleauctionapi.dto;

import net.nerddash.simpleauctionapi.model.ApiEntity;

public interface Form<E extends ApiEntity> {
	E toEntity();
	E updateEntity(E savedEntity);
}
