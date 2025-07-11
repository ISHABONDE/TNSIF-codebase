package com.tnsif.dayten.singledimensiondemo;

public class ArrayobjectDemo {

	
	public static void main(String[] args) {
		
		
		Student[] arr;
		//declared memory for 5 object or type students
		arr=new Student[5];
		arr[0]=new Student(101,"isha");
		arr[1]=new Student(102,"trupti");
		arr[2]=new Student(103,"ashwini");
		arr[3]=new Student(104,"priya");
		arr[4]=new Student(105,"tanmay");
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("elements at "+ i+ ":"+arr[i].getRoll_No()+"    "+arr[i].getName());
		}
		
	}
}
