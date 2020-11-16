package net.nerddash.simpleauctionapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.nerddash.simpleauctionapi.dto.DTO;
import net.nerddash.simpleauctionapi.model.ApiEntity;

public interface ApiService<E extends ApiEntity> {

	E validate(E entity) throws Exception;

	List<E> findExisting(E entity);

	Long delete(Long id);

	Optional<E> findById(Long id);

	E save(E entity);

	Page<? extends DTO<E>> listAllDTO(Pageable pageable);

	DTO<E> entityToDto(E entity);

	boolean shouldUpdate(E entity);

	boolean shouldRead(E entity);

}
