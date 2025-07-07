package com.tnsif.dayeight.interfaceDemo;

public interface Bank {
	
	 float MINBAL= 5000;
	float Deposit_limit=25000;
	
	public void  deposit(float amount);
	public void  withdraw(float amount);
	

}
