package com.tnsif.dayeleven.multiplecatchblocks;

public class NestedTryCatch {
	
	public static void check() {
		String str="TNSIF";
		int slength =str.length();
		System.out.println("string length:"+slength);
		
		String anotherString = null;
		int y=6;
		try {
			//inner try block
			try {
				System.out.println(str.charAt(y));
				
			}
			catch(StringIndexOutOfBoundsException e) {
				System.err.println(e.getMessage());
			}
			System.out.println("string length:"+anotherString.length()););
		}
		catch(NullPointerException e) {
			System.err.println(e.getMessage());
		}
	}

}
