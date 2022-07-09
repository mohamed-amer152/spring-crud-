package com.amer.spring.crud_bcrybt.service;

import java.util.List;

import com.amer.spring.crud_bcrybt.entity.Student;

public interface studentservice {
	
	public List<Student> findall();
	
	public Student findbyid(int sid);
	
	public void save(Student s) ;
	
	public void delete(int sid);
	
	public List<Student> search(String name);

}
