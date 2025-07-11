package com.tnsif.dayeleven.trycatch;

public class UncheckedException {

	public static void main(String[] args) {
		int x[];
		try {
			x=new int[] {1,2,3,4,5,6};
			System.out.println(x[7]);
			
	}
		catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("given index does not exist");
		}
}
}