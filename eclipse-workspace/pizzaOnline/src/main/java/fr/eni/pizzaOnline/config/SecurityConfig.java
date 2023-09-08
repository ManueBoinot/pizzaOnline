package fr.eni.pizzaOnline.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import fr.eni.pizzaOnline.entity.Utilisateur;
import fr.eni.pizzaOnline.service.UtilisateurServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	UtilisateurServiceImpl utilisateurServiceImpl;

	@Bean
	public PasswordEncoder encoder() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return encoder;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(requests) -> requests.requestMatchers("/private/**").authenticated().anyRequest().permitAll()

		).formLogin((form) -> form.loginPage("/login").permitAll()).logout((logout) -> logout.permitAll());

		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {

		List<Utilisateur> utilisateurs = utilisateurServiceImpl.consulterUtilisateurs();
		InMemoryUserDetailsManager mem = new InMemoryUserDetailsManager();

		for (Utilisateur user : utilisateurs) {
			UserDetails userDetails = User.withUsername(user.getEmail())
					.password(encoder().encode(user.getMotDePasse())).roles(user.getRole().getLibelle()).build();
			mem.createUser(userDetails);
		}
		return mem;
	}

}