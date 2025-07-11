package com.tnsif.dayeleven.trycatch;

public class TryCatchExample {
	
	static void performDivision(int a,int b) {
		int c;
		try {
			System.out.println("in try block");
			c=a/b;
			System.out.println("result:"+c);
		}
		
		
		catch(ArithmeticException e) {
			System.err.println("in catch block");
		}
	}

}
