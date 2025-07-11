package com.tnsif.dayeleven.multiplecatchblocks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Division {
 public static void Divide() {
	 int a,b,c;
	 Scanner sc= new Scanner(System.in);
	 System.out.println("enter two numbers:");
	 
	 try {
		 a=sc.nextInt();
		 b=sc.nextInt();
		 c=a/b;
		 System.out.println("division is:"+c);
		 
	 }
	 catch(InputMismatchException e) {
		 System.out.println(e.getMessage());
	 }
	 
	 catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
		 System.out.println(e.getMessage());
	 }
 }
}
