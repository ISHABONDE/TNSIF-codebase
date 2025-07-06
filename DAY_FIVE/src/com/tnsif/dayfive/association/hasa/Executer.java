package com.tnsif.dayfive.association.hasa;

public class Executer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Address address=new Address("509,aayush park", "Pune", "Maharashtra", "410507");
	
	
		Person p=new Person("ISHA", address);
		p.displayInfo();
		System.out.println(p);
	
	
	
	}
}
