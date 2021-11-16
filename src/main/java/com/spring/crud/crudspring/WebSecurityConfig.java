package com.spring.crud.crudspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors().and().csrf().disable().authorizeRequests()
			.antMatchers("/", "/home", "/login").permitAll()
			.antMatchers(HttpMethod.GET,"/produtos", "/produtos/*", "/usuarios", "/usuarios/*").permitAll()
			.antMatchers(HttpMethod.POST, "/login", "/usuarios", "/produtos").permitAll()
			.antMatchers(HttpMethod.PUT, "/usuarios/*", "/produtos/*").permitAll()
			.antMatchers(HttpMethod.DELETE, "/usuarios/*", "/produtos/*").permitAll()
			.anyRequest().authenticated();
	}
	
	@Bean
    CorsConfigurationSource corsConfigurationSource()
    {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

}
