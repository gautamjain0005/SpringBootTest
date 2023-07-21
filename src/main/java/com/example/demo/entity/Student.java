package com.example.demo.entity;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Student_Table")
public class Student {
	@Id
	private int student_id;
	private String name;
	private String about;
	
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Address> address_list = new ArrayList<>();

	public Student(int student_id, String name, String about, List<Address> address_list) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.about = about;
		this.address_list = address_list;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Address> getAddress_list() {
		return address_list;
	}

	public void setAddress_list(List<Address> address_list) {
		this.address_list = address_list;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name + ", about=" + about+"]";
	}
	
	
}
