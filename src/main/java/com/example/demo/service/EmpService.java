package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmpRepo;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepo emprepo;
	
	public void AddEmp(Employee e)
	{
		emprepo.save(e);
	}
	
	public List<Employee> getAllEmp()
	{
		return emprepo.findAll();
	}
}
