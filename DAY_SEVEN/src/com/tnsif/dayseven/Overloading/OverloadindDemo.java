package com.tnsif.dayseven.Overloading;

public class OverloadindDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Point p= new Point(); // default
		System.out.println(p);
		
		Point p1 = new Point(20.09f, 50.98f);
				System.out.println();
				
				System.out.println( " .... Method Overloading .........");
				System.out.println(methodOverloading.addition(3.14f, 23.67f));
				System.out.println(methodOverloading.addition(1,2,3));

	}
}
