package net.nerddash.simpleauctionapi.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import net.nerddash.simpleauctionapi.dto.DTO;
import net.nerddash.simpleauctionapi.dto.Form;
import net.nerddash.simpleauctionapi.model.ApiEntity;

public interface ApiResource<E extends ApiEntity, F extends Form<E>> {

	String controllerPath();

	E formToEntity(F form) throws Exception;

	public ResponseEntity<? extends DTO<E>> create(F form, UriComponentsBuilder uriBuilder) throws Exception;

	public ResponseEntity<? extends DTO<E>> read(Long id) throws Exception;

	public ResponseEntity<? extends DTO<E>> update(Long id, F form) throws Exception;

	public ResponseEntity<?> delete(Long id) throws Exception;

	public Page<? extends DTO<E>> listAll(Pageable pageable);

}
