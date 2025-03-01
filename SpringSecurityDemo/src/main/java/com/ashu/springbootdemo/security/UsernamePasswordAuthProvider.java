package com.ashu.springbootdemo.security;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ashu.springbootdemo.model.Person;
import com.ashu.springbootdemo.model.Roles;
import com.ashu.springbootdemo.repository.PersonRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UsernamePasswordAuthProvider implements AuthenticationProvider {

	private PersonRepository personRespository;
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		Person person = personRespository.getByEmail(username);
		if (Objects.nonNull(person) && passwordEncoder.matches(password, person.getPwd())) {
			return new UsernamePasswordAuthenticationToken(person.getName(), null,
					getGrantedAuthorities(person.getRole()));
		} else {
			throw new BadCredentialsException("Invalid Credentials");
		}
	}

	private List<GrantedAuthority> getGrantedAuthorities(Roles role) {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
