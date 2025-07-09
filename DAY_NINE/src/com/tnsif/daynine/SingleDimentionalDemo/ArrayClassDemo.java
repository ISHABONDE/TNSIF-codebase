package com.tnsif.daynine.SingleDimentionalDemo;

import java.util.Arrays;


public class ArrayClassDemo {

	
		public static void main(String[] args) {
			
			//get the array
			
			int intArr[] = {69,20,12,40,35};
			
			//print the arraY
			
			System.out.println(Arrays.toString(intArr));
			for(int i = 0; i<intArr.length; i++) {
				System.out.println(intArr[i] + " ");
				
		
			
			
			// sort
			
			Arrays.sort(intArr);
			System.out.println(Arrays.toString(intArr));
			
			//binary
			
			System.out.println(Arrays.binarySearch(intArr, 50));
			
			//get the second array
			
			int intArr1[] = {69,20,12,40,35};
			System.out.println(Arrays.toString(intArr));
			
			Arrays.sort(intArr1);
			
			//comparing the both array
			
			if(Arrays.compare(intArr, intArr1)==0)
			{
				System.out.println("Both the array same");
				
			}
			else
			{
				System.out.println("both array not same");
			}
			
			//copy array
			
			int intArr2[] = Arrays.copyOf(intArr, 2);
			System.out.println(Arrays.toString(intArr2));
			
			int intArr3[] = Arrays.copyOfRange(intArr1, 2 , 4);
			System.out.println(Arrays.toString(intArr3));
			
			//fill method
			Arrays.fill(intArr, 7);
			System.out.println(Arrays.toString(intArr3));
			
			
			
			
		}

	}
}
