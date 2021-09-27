package com.mohd.khan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.modh.khan.dto.Department;
import com.modh.khan.dto.UserResponse;
import com.mohd.khan.dao.UserDao;
import com.mohd.khan.entity.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserDao userDao;
	
	public UserResponse getUser(Long userId) {
		log.info("Inside getUser() method.");
		UserResponse userResponse = new UserResponse();
		User user = userDao.findById(userId).orElse(null);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/dept/get/" + user.getDeptId(), Department.class);
		//Department department = restTemplate.getForObject("http://localhost:9001/dept/get/" + user.getDeptId(), Department.class);
		userResponse.setUser(user);
		userResponse.setDepartment(department);
		log.info("Exiting getUser() method.");
		return userResponse;
	}
	
	public User addUser(User user) {
		log.info("Inside addUser() method.");
		return userDao.save(user);
	}

}
