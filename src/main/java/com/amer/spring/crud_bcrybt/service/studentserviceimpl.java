package com.amer.spring.crud_bcrybt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amer.spring.crud_bcrybt.dao.studentdao;
import com.amer.spring.crud_bcrybt.entity.Student;

@Service
public class studentserviceimpl implements studentservice {

	@Autowired
	private studentdao repo ;
	
	@Override
	public List<Student> findall() {

		List<Student> studentlist = repo.findAll();
		return studentlist;
	}

	@Override
	public Student findbyid(int sid) {
      
		Optional<Student> result = repo.findById(sid);
		if (result.isPresent()) {
			Student s = result.get();
			return s ;
		} else {
			return null;
		}
		
	}

	@Override
	public void save(Student s) {
       repo.save(s);
	}

	@Override
	public void delete(int sid) {
      repo.deleteById(sid);
	}

	@Override
	public List<Student> search(String name) {

		if (name != null) {
			List<Student> studentlist = repo.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(name, name);
			return studentlist;
		} else {
			return repo.findAll();
		}
		
	}

}
