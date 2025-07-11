package com.tnsif.dayten.singledimensiondemo;


//entity
public class Student {

	 //data members
	private int roll_No;
	private String Name;
	
	//para constructor
	public Student(int roll_No, String name) {
		
		this.roll_No = roll_No;
		Name = name;
		
		//getetr-setter
		
		
	}

	public int getRoll_No() {
		return roll_No;
	}

	public void setRoll_No(int roll_No) {
		this.roll_No = roll_No;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	
	
}
