package com.tnsif.dayten.multidimensiondemo;


class MLArray{
	static void printArray(int c[][]) {
		System.out.println("elements of array are as followed");
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c.length;j++) {
				System.out.println(c[i][j]+" ");
			}
			System.out.println();
		}
	}
}
public class MultiDimensionArrayDemo {
public static void main(String[] args) {
	int c[][]= {{12,34,60},{10,20,30},{1,2},{78,87}};
	System.out.println("no. of row in c array :"+c.length);
	MLArray.printArray(c);
}
}
