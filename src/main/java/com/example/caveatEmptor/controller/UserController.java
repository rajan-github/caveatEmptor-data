package com.example.caveatEmptor.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.caveatEmptor.exception.UserNotFoundException;
import com.example.caveatEmptor.model.simple.User;
import com.example.caveatEmptor.service.UserService;

import com.example.caveatEmptor.util.Error;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/save", produces = "application/json", consumes = "text/json")
	public ResponseEntity<User> saveUser(@RequestBody User user, UriComponentsBuilder ucb) {
		User savedUser = userService.save(user);
		HttpHeaders headers = new HttpHeaders();
		URI locationUri = ucb.path("/user/").path(String.valueOf(savedUser.getId())).build().toUri();
		headers.setLocation(locationUri);
		return new ResponseEntity<User>(savedUser, headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public User userById(@PathVariable Long id) {
		User user = userService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException(id);
		}
		return user;
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error userNotFound(UserNotFoundException e) {
		long userId = e.getUserId();
		return new Error(4, "User [" + userId + "] not found.");
	}

}
