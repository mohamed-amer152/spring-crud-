package com.amer.spring.crud_bcrybt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amer.spring.crud_bcrybt.entity.Student;
import com.amer.spring.crud_bcrybt.service.studentservice;

@Controller
@RequestMapping("/student")
public class studentcontroller {

	@Autowired
	private studentservice service ;
	
	@GetMapping("/list")
	public String studentlist(Model model)
	{
		List<Student> studentlist = service.findall();
		model.addAttribute("students", studentlist);
		return "view/students";
	}
	
	
	@GetMapping("/saveform")
	public String saveform(Model model)
	{
		Student std = new Student();
		model.addAttribute("student", std);
		return "view/saveform";
	}
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute Student std )
	{
		service.save(std);
		return "redirect:/student/list";
	}
	
	@GetMapping("/updateform")
	public String updateform(@RequestParam int sid , Model model)
	{
		Student std = service.findbyid(sid);
		model.addAttribute("student", std);
		return "view/saveform";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int sid )
	{
		service.delete(sid);
		return "redirect:/student/list";
	}
	
	
	@GetMapping("/search")
	public String search(@RequestParam String studentname , Model model)
	{
		List<Student> studentlist = service.search(studentname);
		model.addAttribute("students", studentlist);
		return "view/students";
	}
	
	
	
	
	
	
	
}
