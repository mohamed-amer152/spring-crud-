package com.amer.spring.crud_bcrybt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amer.spring.crud_bcrybt.entity.Student;

public interface studentdao extends JpaRepository<Student, Integer> {
	
	public List<Student> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String fname , String lname);

}
