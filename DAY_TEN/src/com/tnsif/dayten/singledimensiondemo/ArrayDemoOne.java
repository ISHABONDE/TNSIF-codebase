package com.tnsif.dayten.singledimensiondemo;

public class ArrayDemoOne {

public static void main(String[] args) {
		
		int n=10;
		int a[]; //declaration 
		a=new int[n]; // instantiation
		
		//displaying the array 
		ArrayOperations.printArray(a);
		
		//assigning values in array a
		for(int i=0; i<a.length; i++)
		{
			a[i]=5*i;
			ArrayOperations.printArray(a);
			
		}
		
		int b[] = {10,20,30,40,50}; // initialization at the time of declaration 
		ArrayOperations.printArray(b);
		
		//calling of variables argument function 
		System.out.println("Sum of array elements is :"+ ArrayOperations.getSum(b));
		System.out.println("Sum of array elements is : "+ ArrayOperations.getSum(10,20,30,40,60,80));
		
		b[2]= 999; //assigning single elements
		
		ArrayOperations.printArray(b);
		
		//displaying total odd and even no 
		System.out.println("Odd number : "+ ArrayOperations.getOddCount(b)
		+"\t Even no : "+ ArrayOperations.getEvenCount(b));
	
		System.out.println();
		
		

	}
}
