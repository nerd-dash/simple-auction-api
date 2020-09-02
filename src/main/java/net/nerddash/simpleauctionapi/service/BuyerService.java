package net.nerddash.simpleauctionapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.nerddash.simpleauctionapi.dto.BuyerDTO;
import net.nerddash.simpleauctionapi.dto.BuyerForm;
import net.nerddash.simpleauctionapi.dto.DTO;
import net.nerddash.simpleauctionapi.model.Buyer;
import net.nerddash.simpleauctionapi.model.Role;
import net.nerddash.simpleauctionapi.repository.BuyerRepository;

@Service
public class BuyerService extends ApiServiceImpl<Buyer, BuyerRepository> implements ApiService<Buyer> {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public BuyerDTO entityToDto(Buyer buyer) {
		return new BuyerDTO(buyer);
	}

	@Override
	public Page<? extends DTO<Buyer>> listAllDTO(Pageable pageable) {
		Page<Buyer> findAll = repository.findAll(pageable);
		return findAll.map(BuyerDTO::new);
	}

	public BuyerForm encodePassword(BuyerForm form) {
		String rawPassword = form.getPhoneNumberCrypt();
		form.setPhoneNumberCrypt(passwordEncoder.encode(rawPassword));
		return form;
	}

	@Override
	public boolean shouldUpdate(Buyer buyer) {
		return isSelfRequest(buyer) || isAdmin();
	}

	@Override
	public boolean shouldRead(Buyer buyer) {
		return isSelfRequest(buyer) || isAdmin();
	}

	protected boolean isSelfRequest(UserDetails userDetails) {
		Optional<Buyer> loggedBuyer = getLoggedBuyer();
		return (loggedBuyer.isPresent() && loggedBuyer.get().getPhoneNumber() == userDetails.getUsername());
	}

	protected boolean isAdmin() {
		Optional<Buyer> loggedBuyer = getLoggedBuyer();
		boolean isAdminProfile = loggedBuyer.get()
				.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority).filter(Role.ROLE_ADMIN.name()::equals)
				.findFirst().isPresent();
		return (loggedBuyer.isPresent() && isAdminProfile);
	}

	protected Optional<Buyer> getLoggedBuyer() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String phoneNumber = auth.getName();
		return repository.findByPhoneNumber(phoneNumber);

	}

}
