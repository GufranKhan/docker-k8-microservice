package com.mohd.khan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohd.khan.entity.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {

}
