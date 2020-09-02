package net.nerddash.simpleauctionapi.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.nerddash.simpleauctionapi.model.Buyer;
import net.nerddash.simpleauctionapi.repository.BuyerRepository;

@Service
public class ApiUserDetailsService implements UserDetailsService {

	@Autowired
	private BuyerRepository buyerRepository;

	@Override
	public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
		Optional<Buyer> buyer = buyerRepository.findByPhoneNumber(phoneNumber);

		if (buyer.isPresent()) {
			return buyer.get();
		}

		throw new UsernameNotFoundException("Telefone não cadastrado!");
	}

}
