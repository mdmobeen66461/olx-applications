package com.zensar.olxadvertise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
		.withUser("mubeen")
		.password("mubeen@123")
		.roles("Developer")
		.and()
		.withUser("sameer")
		.password("sameer123")
		.roles("Admin");
		
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http .csrf().disable() .authorizeRequests() .anyRequest().permitAll(); 
        
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	

}