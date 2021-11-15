package com.spring.crud.crudspring;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable().authorizeRequests()
			.antMatchers("/", "/home").permitAll()
			.antMatchers(HttpMethod.GET,"/produtos").permitAll()
			.antMatchers(HttpMethod.GET,"/produtos/*").permitAll()
			.antMatchers(HttpMethod.GET, "/usuarios/*").permitAll()
			.antMatchers(HttpMethod.GET, "/usuarios").permitAll()
			.antMatchers(HttpMethod.POST, "/usuarios").permitAll()
			.antMatchers(HttpMethod.PUT, "/usuarios/*").permitAll()
			.antMatchers(HttpMethod.DELETE, "/usuarios/*").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
		.logout()
			.permitAll();
	}
}
