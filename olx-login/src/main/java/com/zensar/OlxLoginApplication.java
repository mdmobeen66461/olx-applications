package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zensar.entity.User;

@SpringBootApplication
public class OlxLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxLoginApplication.class, args);
		
//		User user=new User();
//		
//		user.setEmail("mubeen@gmail.com");
//		System.out.println(user.getEmail());
	}

}
