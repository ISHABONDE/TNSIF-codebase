package com.tnsif.daynine.StringDemo;

public class StringbugfferDemo {

	public static void main(String[] args) {
		//string buffer length
		StringBuffer buffer =new StringBuffer("hello");
		System.out.println(buffer);
		System.out.println(buffer.length());
		System.out.println(buffer.capacity());
		//appending and insetting into buffer
		String s;
		int a=42;
		buffer=new StringBuffer(40);
		s=buffer.append("a=").append(a).append("!").toString();
		System.out.println(a);
		System.out.println(buffer);
		
		buffer =new StringBuffer("I  Java");
		buffer.insert(2, "like");
		System.out.println(buffer);
		
		buffer.delete(3, 6);
		System.out.println(buffer);
		
		buffer.reverse();
		System.out.println(buffer);
		System.out.println(s.hashCode());
		
	}
}
