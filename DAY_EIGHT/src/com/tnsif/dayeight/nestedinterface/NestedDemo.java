package com.tnsif.dayeight.nestedinterface;

public class NestedDemo implements OuterInterface ,OuterInterface.InnerInterface {

	@Override
	public void calArea() {
		System.out.println("method of outer-interface");
		
	}

	@Override
	public void print() {
		System.out.println("method of inner-interface");
		
	}
	

}
