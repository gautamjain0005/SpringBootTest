package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Student;
import com.example.demo.repository.AddressRepo;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepo ar;
	
	public List<Address> getAddressList(Student student)
	{
		return student.getAddress_list();
	}
	public Address getAddressById(int id)
	{
		return ar.findById(id).get();
	}
}
