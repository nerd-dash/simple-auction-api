package net.nerddash.simpleauctionapi.resource;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import net.nerddash.simpleauctionapi.dto.DTO;
import net.nerddash.simpleauctionapi.dto.Form;
import net.nerddash.simpleauctionapi.model.ApiEntity;
import net.nerddash.simpleauctionapi.service.ApiService;

public abstract class ApiResourceImpl<E extends ApiEntity, F extends Form<E>, S extends ApiService<E>>
		implements ApiResource<E, F> {

	@Autowired
	protected S service;

	@Override
	public String controllerPath() {

		@SuppressWarnings("rawtypes")
		Class<? extends ApiResource> class1 = this.getClass();
		RequestMapping annotation = class1.getAnnotation(RequestMapping.class);
		String[] value = annotation.value();
		if (value.length == 0) {
			return null;
		} else {
			return value[0];
		}

	}

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Page<? extends DTO<E>> listAll(
			@PageableDefault(page = 0, size = 10, sort = "updatedAt", direction = Direction.DESC) Pageable pageable) {
		return service.listAllDTO(pageable);
	}

	@GetMapping("/{id}")
	@PreAuthorize("permitAll()")
	public ResponseEntity<? extends DTO<E>> read(@PathVariable Long id) throws Exception {
		Optional<E> optional = service.findById(id);

		if (optional.isPresent() && service.shouldRead(optional.get())) {
			return ResponseEntity.ok(service.entityToDto(optional.get()));
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND);

	}

	@PostMapping
	@Transactional
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<? extends DTO<E>> create(@Valid @RequestBody F form, UriComponentsBuilder uriBuilder)
			throws Exception {
		E entity = formToEntity(form);
		if (entity != null) {
			E valid = service.validate(entity);
			E saved = service.save(valid);
			URI uri = uriBuilder.path(controllerPath() + "/{id}").buildAndExpand(saved.getId()).toUri();
			return ResponseEntity.created(uri).body(service.entityToDto(saved));
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	@Transactional
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<? extends DTO<E>> update(@PathVariable Long id, @Valid @RequestBody F form) throws Exception {
		Optional<E> optional = service.findById(id);

		if (optional.isPresent() && service.shouldUpdate(optional.get())) {
			E entity = form.updateEntity(optional.get());
			if (entity != null) {
				return ResponseEntity.ok(service.entityToDto(entity));
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	@Transactional
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<E> delete(@PathVariable Long id) {

		Long deletedId = this.service.delete(id);

		if (deletedId != null) {

			return ResponseEntity.ok().build();

		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);

	}

	@Override
	public E formToEntity(F form) throws Exception {
		return form.toEntity();
	}

}
