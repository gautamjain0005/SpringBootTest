package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cake;
import com.example.demo.entity.Student;
import com.example.demo.repository.CakeRepo;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo repo;
	
	public void saveStudent(Student s)
	{ 
		repo.save(s);
	}
	
	public Student getStudent(int id)
	{
		Student student = repo.findById(id).get();
		return student;
	}
}
