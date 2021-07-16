package com.ec.onlineplantnursery.security;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ec.onlineplantnursery.service.UserServiceImpl;


@Configuration
@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
    public UserServiceImpl userservice;
	@Autowired
	JwtAuthenticationFilter jwtfilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userservice);
		
	}
	//helloo
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	         http 	              
	              .cors().and()
	              .csrf().disable()
	              .authorizeRequests()
	              .antMatchers("/onlinenursery/customer/add","/user/signin","/onlinenursery/seed/add").permitAll()
	              .anyRequest().authenticated()
	              .and()
	              .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                  http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
				

	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
 
}