package com.tnsif.daynine.StringDemo;

public class SampleStringDemo {

	public static void main(String[] args) {
		// initialize string
		char c[]= {'i','s','h','a'};
		
		String s1=new String();
		System.out.println(s1);
		
		String s2= new String(s1);
		System.out.println(s2);
		
		//concatination to prevent long lines
		String longstr="this is to show"+" "+"how long sentances"+" "+"can be printed";
		System.out.println(longstr);
	}
}
