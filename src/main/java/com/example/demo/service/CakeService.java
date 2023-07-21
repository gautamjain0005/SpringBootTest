package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cake;
import com.example.demo.repository.CakeRepo;

@Service
public class CakeService {
	@Autowired
	private CakeRepo cakerepo;
	
	public void addCake(Cake cake)
	{
		cakerepo.save(cake);
	}
}
