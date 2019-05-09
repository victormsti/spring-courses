package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;


public class Customer {

	private String firstName;
	
	@NonNull
	@Size(min=1, message="is required")
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
