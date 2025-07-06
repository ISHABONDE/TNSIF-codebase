package com.tnsif.dayfive.hierarchicalinheritance;

public class HierachicalDriver {

public static void main(String[] args) {
		
		
		Person p1=new Person();
		System.out.println("------Person Details ------");
		System.out.println(p1);
		
		System.out.println("--------------------------");
		//Student s=new Student();
		Person p;
		p=new Person("ISHA", "AHMEDABAD");
		System.out.println("Person Details "+ p);
		
		p=new Student("TANMAY", "BARAMATI", "BE", 77.89f);
		System.out.println("Students details "+ p);
		
		p=new Employee("PRIYA", "Nagar", 1002, 450000, "Development");
		System.out.println("employee details "+ p);
		


		
	}

}
