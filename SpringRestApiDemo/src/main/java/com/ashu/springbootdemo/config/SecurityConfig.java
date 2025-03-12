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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(request -> request.anyRequest().permitAll());
//		http.authorizeHttpRequests(request -> request.anyRequest().denyAll());
//		http.csrf(csrf -> csrf.disable());

		http.csrf((csrf) -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/saveMsg"))
				.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/public/**"))
				.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/api/contact/**")))
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers(AntPathRequestMatcher.antMatcher("/dashboard")).authenticated())
				.authorizeHttpRequests(authorize -> authorize.requestMatchers(AntPathRequestMatcher.antMatcher("/"),
						AntPathRequestMatcher.antMatcher("/home")).permitAll())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(AntPathRequestMatcher.antMatcher("/assets/**")).permitAll())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(AntPathRequestMatcher.antMatcher("/holidays/**")).permitAll())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(AntPathRequestMatcher.antMatcher("/admin/**")).permitAll())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(AntPathRequestMatcher.antMatcher("/contact")).permitAll())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(AntPathRequestMatcher.antMatcher("/saveMsg")).permitAll())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(AntPathRequestMatcher.antMatcher("/public/**")).permitAll())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(AntPathRequestMatcher.antMatcher("/api/contact/**")).permitAll())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(AntPathRequestMatcher.antMatcher("/courses")).permitAll())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(AntPathRequestMatcher.antMatcher("/updateProfile")).permitAll())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(AntPathRequestMatcher.antMatcher("/displayProfile")).permitAll())
				.authorizeHttpRequests(
						authorize -> authorize.requestMatchers(AntPathRequestMatcher.antMatcher("/displayMessages/**"),
								AntPathRequestMatcher.antMatcher("/closeMessage/**")).hasRole("ADMIN"))
				.authorizeHttpRequests(
						authorize -> authorize.requestMatchers(AntPathRequestMatcher.antMatcher("/login")).permitAll())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(AntPathRequestMatcher.antMatcher("/logout")).permitAll());
		http.formLogin(login -> login.loginPage("/signin").defaultSuccessUrl("/dashboard")
				.failureUrl("/signin?error=true").permitAll());
		http.logout(logout -> logout.logoutSuccessUrl("/signin?logout=true").invalidateHttpSession(true).permitAll());
		http.httpBasic(withDefaults());
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsService() {
	 * 
	 * UserDetails user =
	 * User.withDefaultPasswordEncoder().username("Demo").password("Demo@1234").
	 * roles("USER") .build();
	 * 
	 * UserDetails admin =
	 * User.withDefaultPasswordEncoder().username("admin").password("Demo@1234").
	 * roles("ADMIN") .build();
	 * 
	 * 
	 * UserDetails user =
	 * User.withUsername("Demo").password("Demo@1234").roles("USER").build();
	 * UserDetails asdmin =
	 * User.withUsername("Admin").password("Demo@1234").roles("USER",
	 * "ADMIN").build();
	 * 
	 * return new InMemoryUserDetailsManager(user, admin); }
	 */}
