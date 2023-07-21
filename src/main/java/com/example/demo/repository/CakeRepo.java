package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cake;

@Repository
public interface CakeRepo extends JpaRepository<Cake, Integer>{

}
