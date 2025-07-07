package com.tnsif.dayeight.interfaceDemo;


//Entity
public class Customer {

	//datamembers
	private String name;
	private String city;
	
	//getter and setter methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	//default constructor
	public Customer() {
		
	}
	
	//para constructor
	public Customer(String name, String city) {
		
		this.name = name;
		this.city = city;
	}
	
	
	
}
