package com.mohd.khan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modh.khan.dto.UserResponse;
import com.mohd.khan.entity.User;
import com.mohd.khan.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/get/{id}")
	public UserResponse getUser(@PathVariable("id") Long userId) {
		return userService.getUser(userId);
	}
	
	@PostMapping("/add")
	public User getUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}
