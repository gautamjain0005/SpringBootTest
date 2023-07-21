package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.CakeRepo;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;


@SpringBootApplication
public class Application {
	
	@Autowired
	private StudentRepo studentrepo;
	
	@Autowired
	private CakeRepo cakerepo;
	
	@Autowired
	private StudentService ss;
	
	//private Logger logger = (Logger) LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	
}
