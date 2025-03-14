package com.ashu.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(request -> request.anyRequest().permitAll());
//		http.authorizeHttpRequests(request -> request.anyRequest().denyAll());
//		http.csrf(csrf -> csrf.disable());
		http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/dashboard").permitAll())
				.authorizeHttpRequests(authorize -> authorize.requestMatchers("", "/", "/home").permitAll())
				.authorizeHttpRequests(authorize -> authorize.requestMatchers("/assets/**").permitAll())
				.authorizeHttpRequests(authorize -> authorize.requestMatchers("/holidays/**").permitAll())
				.authorizeHttpRequests(authorize -> authorize.requestMatchers("/contact").permitAll())
				.authorizeHttpRequests(authorize -> authorize.requestMatchers("/saveMsg").permitAll())
				.authorizeHttpRequests(authorize -> authorize.requestMatchers("/courses").permitAll())
				.authorizeHttpRequests(authorize -> authorize.requestMatchers("/login").permitAll())
				.authorizeHttpRequests(authorize -> authorize.requestMatchers("/logout").permitAll())
				.csrf(csrf -> csrf.ignoringRequestMatchers("/saveMsg"));
		http.formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/dashboard")
				.failureUrl("/login?error=true").permitAll());
		http.logout(logout -> logout.logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll());
		http.httpBasic(withDefaults());
		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {

		UserDetails user = User.withDefaultPasswordEncoder().username("Demo").password("Demo@1234").roles("USER")
				.build();

		UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("Demo@1234")
				.roles("ADMIN", "USER").build();

		/*
		 * UserDetails user =
		 * User.withUsername("Demo").password("Demo@1234").roles("USER").build();
		 * UserDetails admin =
		 * User.withUsername("Admin").password("Demo@1234").roles("USER",
		 * "ADMIN").build();
		 */
		return new InMemoryUserDetailsManager(user, admin);
	}
}
