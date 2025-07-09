package com.tnsif.daynine.StringDemo;

public class WrapperClassDemo {
	
	public static void main(String[] args) {
		
		//unboxing
		Integer i=new Integer(10);
		System.out.println(i);
		int b =i.intValue();
		System.out.println(b);
		
		//without using intValue();
		int c=1;
		System.out.println(c);
		
		//AutoBoxing
		int a=100;
		Integer i1=a;
		System.out.println(i1);
	}

}
