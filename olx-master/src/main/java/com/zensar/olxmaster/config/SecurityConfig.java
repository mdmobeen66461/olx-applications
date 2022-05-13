package com.zensar.olxmaster.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*auth.inMemoryAuthentication()
		.withUser("mubeen")
		.password("mubeen@123")
		.roles("Developer")
		.and()
		.withUser("sameer")
		.password("sameer123")
		.roles("Admin");*/
		
		auth.userDetailsService(userDetailsService);
		
	}
	
	
	/*  @Override protected void configure(HttpSecurity http) throws Exception { 
		  http.csrf().disable() .authorizeRequests()
		  .antMatchers("/stocks/create")
		  .hasRole("ADMIN");
	  
	  }*/
	 
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	

}
