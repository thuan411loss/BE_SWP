package service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import model.Account;
import repository.AccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

		return User.builder()
				.username(account.getUsername())
				.password(account.getPasswordHash())
				.authorities(Collections.singletonList(
						new SimpleGrantedAuthority("ROLE_" + account.getUser().getRole().getRoleName())))
				.accountExpired(false)
				.accountLocked(!account.getIsActive())
				.credentialsExpired(false)
				.disabled(!account.getIsActive())
				.build();
	}
}
