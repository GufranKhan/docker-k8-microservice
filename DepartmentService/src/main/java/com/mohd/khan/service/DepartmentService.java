package com.mohd.khan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohd.khan.dao.DepartmentDao;
import com.mohd.khan.entity.Department;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	
	public Department getDepartment(Long id) {
		log.info("Inside getDepartment() method.");
		return departmentDao.findById(id).orElse(null);
	}
	
	public Department addDepartment(Department department) {
		log.info("Inside addDepartment() method.");
		return departmentDao.save(department);
	}
}
