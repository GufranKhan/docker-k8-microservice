package com.mohd.khan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohd.khan.entity.Department;
import com.mohd.khan.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/get/{id}")
	public Department getDepartment(@PathVariable("id") Long departmentId) {
		return departmentService.getDepartment(departmentId);
	}
	
	@PostMapping("/add")
	public Department addDepartment(@RequestBody Department department) {
		return departmentService.addDepartment(department);
	}
}
