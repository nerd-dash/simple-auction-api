package net.nerddash.simpleauctionapi.resource;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import net.nerddash.simpleauctionapi.dto.BuyerForm;
import net.nerddash.simpleauctionapi.dto.DTO;
import net.nerddash.simpleauctionapi.model.Buyer;
import net.nerddash.simpleauctionapi.service.BuyerService;

@RestController
@RequestMapping("/buyers")
public class BuyerResource extends ApiResourceImpl<Buyer, BuyerForm, BuyerService> {

	@Override
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_BUYER')")
	public ResponseEntity<? extends DTO<Buyer>> read(@PathVariable Long id) throws Exception {
		return super.read(id);
	}

	@Override
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<? extends DTO<Buyer>> create(@RequestBody @Valid BuyerForm form,
			UriComponentsBuilder uriBuilder) throws Exception {
		service.encodePassword(form);
		return super.create(form, uriBuilder);
	}

	@Override
	@PutMapping("/{id}")
	@Transactional
	@PreAuthorize("hasAuthority('ROLE_BUYER')")
	public ResponseEntity<? extends DTO<Buyer>> update(@PathVariable Long id, @Valid @RequestBody BuyerForm form)
			throws Exception {
		service.encodePassword(form);
		return super.update(id, form);
	}

}