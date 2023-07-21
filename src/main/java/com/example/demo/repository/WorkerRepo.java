package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Worker;

public interface WorkerRepo extends JpaRepository<Worker, Integer> {
	
	public Worker findByName(String name);
}
