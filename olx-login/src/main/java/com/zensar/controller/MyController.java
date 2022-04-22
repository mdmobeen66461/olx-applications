package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.User;
import com.zensar.service.OlxLoginService;

@RestController
//@RequestMapping(value="/user",produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE},consumes ={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
@RequestMapping("/user")
public class MyController {

	@Autowired
	private OlxLoginService olxLoginService;

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<User> getAllUsers(@RequestHeader("userName") String username,
			@RequestHeader("password") String password) {
		return olxLoginService.getAllUsers(username, password);

	}

	@PostMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> registerUser(@RequestBody User user) {
//		users.add(user);
//		return new ResponseEntity<User>(user,HttpStatus.CREATED);

		User register = olxLoginService.registerUser(user);

		return new ResponseEntity<User>(register, HttpStatus.CREATED);

	}

	@DeleteMapping("/logout/{userId}")
	public boolean logoutUser(@PathVariable("userId") long id1, @RequestHeader("userName") String username,
			@RequestHeader("password") String password) {

		return olxLoginService.logoutUser(id1, username, password);

	}

	@PostMapping(value = "/authenticate", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public String loginUser(@RequestBody User user) {

		return olxLoginService.loginUser(user);

	}

}
