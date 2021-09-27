package com.mohd.khan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USR_TBL")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private String firstName;
	private String lastName;
	private String email;
	private Long deptId;

}
