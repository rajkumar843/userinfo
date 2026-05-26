package com.mrk.userinfo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrk.userinfo.dto.UserDTO;
import com.mrk.userinfo.exception.UserNotfoundException;
import com.mrk.userinfo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usersapi")
@Tag(name = "Userinfo APIs", description = "UserInformation Microservice APIs")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;

	@PostMapping("/addUser")
	@Operation(summary = "Add all UserInformation")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
		UserDTO saveUser = service.adduser(userDTO);
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
	}

	@GetMapping("/fetchById/{id}")
	@Operation(summary = "Fetch a UserInformation")
	public ResponseEntity<UserDTO> fetchById(@PathVariable Integer id) {
		logger.info("Fetching Restaurant with Id {}" + id);
		ResponseEntity<UserDTO> response = service.fetchUserDetailsById(id);
		if (response.getBody() == null) {
			logger.error("user not found with id {}" + id);
			throw new UserNotfoundException("Uesr not found with id" + id);
		}

		return response;
	}
}
