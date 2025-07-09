package com.tnsif.daynine.StringDemo;

public class StringOperaionDemo {
	
	public static void main(String[] args) {
		String s1= new String("Isha is college student");
		System.out.println(s1);
		String s2=s1.toLowerCase();
		System.out.println(s2);
		String s3=s1.toUpperCase();
		System.out.println(s3);
		System.out.println("length of string:  "+s1.length());
	String s4=s1.substring(2, 7);
	System.out.println("substring:"+s4);
	System.out.println("trimmed: "+s1.trim());
		System.out.println(s1.isEmpty());
		
		
		//string comparison
		s2=new String(s1);
		
		//= 
		//equals--->data
		//== --->object reference check
		System.out.println("case1:"+s1.equals(s2));
		System.out.println("case 2:"+s1==s2);
	}

}
