package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Address;
import com.example.demo.entity.Student;
import com.example.demo.repository.AddressRepo;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.AddressService;
import com.example.demo.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentRepo sr;
	
	@Autowired
	private AddressService as;
	
	private AddressRepo ar;
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/addStudent")
	@ResponseBody
	public String addStudent(@RequestBody Student s)
	{
		List<Address> list = s.getAddress_list();
		for(int i=0;i<list.size();i++)
		{
			Address add = list.get(i);
			add.setStudent(s);
		}
		sr.save(s);
		return "success";
	}
	
	@GetMapping("/getStudent/{id}")
	@ResponseBody
	public Student getStudent(@PathVariable int id)
	{
		Student st = service.getStudent(id);
		System.out.println(st.getAddress_list());
		return st;
	}
	
	@GetMapping("/getAddress/{id}")
	@ResponseBody
	public Address getAddress(@PathVariable int id)
	{
		Address ad= as.getAddressById(id);
		System.out.println(ad);
		return ad;
	}
}