package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Cake;
import com.example.demo.repository.CakeRepo;


@Controller
public class CakeController {
	
	@Autowired
	private CakeRepo cakerepo;

	@PostMapping("/addcake")
	@ResponseBody
	public String addCake(@RequestBody Cake cake)
	{
		cakerepo.save(cake);
		return "success";
	}
}
