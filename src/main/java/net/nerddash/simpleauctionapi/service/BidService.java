package net.nerddash.simpleauctionapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import net.nerddash.simpleauctionapi.dto.BidDTO;
import net.nerddash.simpleauctionapi.dto.DTO;
import net.nerddash.simpleauctionapi.model.Bid;
import net.nerddash.simpleauctionapi.model.Buyer;
import net.nerddash.simpleauctionapi.model.Role;
import net.nerddash.simpleauctionapi.repository.BidRepository;
import net.nerddash.simpleauctionapi.repository.BuyerRepository;

@Service
public class BidService extends ApiServiceImpl<Bid, BidRepository>  {

	@Autowired
	private BuyerRepository buyerRepository; 
	
	@Override
	public BidDTO entityToDto(Bid bid) {
		return new BidDTO(bid);
	}

	@Override
	public Page<? extends DTO<Bid>> listAllDTO(Pageable pageable) {
		Page<Bid> findAll = repository.findAll(pageable);
		return findAll.map(BidDTO::new);
	}

	@Override
	public boolean shouldRead(Bid bid) {
		return isSelfRequest(bid) || isAdmin();
	}

	protected boolean isSelfRequest(Bid bid) {
		Optional<Buyer> loggedBuyer = getLoggedBuyer();
		return (loggedBuyer.isPresent() && loggedBuyer.get() == bid.getBuyer());
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
		return buyerRepository.findByPhoneNumber(phoneNumber);

	}

}
