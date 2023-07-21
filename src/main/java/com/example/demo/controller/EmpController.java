package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;


@Controller
public class EmpController {
	
	@Autowired
	private EmpService empS;
	
	@GetMapping("/index")
	public String home(Model model)
	{
		List<Employee> emp = empS.getAllEmp();
		model.addAttribute("emp",emp);
		return "index";
	}
	
	@GetMapping("/getname")
	@ResponseBody
	public String getName()
	{
		return "Anurag yadav";
	}
	
	@GetMapping("/addemp")
	public String AddEmpForm()
	{
		return "AddEmp";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute Employee e)
	{
		System.out.println(e);
		empS.AddEmp(e);
		return "redirect:/";
	}
}
