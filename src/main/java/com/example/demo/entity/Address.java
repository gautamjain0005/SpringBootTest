package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="adress_table")
public class Address {
		

		@Id
		private int address_id;
		private String city;
		private int pincode;
		
		@ManyToOne
		@JoinColumn(name="student_id")
		@JsonBackReference
		private Student student;
		
		public Address(int address_id, String city, int pincode, Student student) {
			super();
			this.address_id = address_id;
			this.city = city;
			this.pincode = pincode;
			this.student = student;
		}
		
		
		
		public Address() {
			super();
			// TODO Auto-generated constructor stub
		}



		public int getAddress_id() {
			return address_id;
		}

		public void setAddress_id(int address_id) {
			this.address_id = address_id;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public int getPincode() {
			return pincode;
		}

		public void setPincode(int pincode) {
			this.pincode = pincode;
		}

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}


		@Override
		public String toString() {
			return "Address [address_id=" + address_id + ", city=" + city + ", pincode=" + pincode+"]";
		}
		
}
