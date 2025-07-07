package com.tnsif.dayeight.interfaceDemo;

public class SavingAccount extends Customer implements Bank{
	//datamembers
	private int actNo;
	private float balance;
	
	
//para constructor
	public SavingAccount(String name, String city,int  actNo, float balance) {
		super();
		this.actNo = actNo;
		this.balance = balance;
	}
	
	//getter - setter

	public int getActNo() {
		return actNo;
	}


	public void setActNo(int actNo) {
		this.actNo = actNo;
	}


	public float getBalance() {
		return balance;
	}


	public void setBalance(float balance) {
		this.balance = balance;
	}


	@Override
	public void deposit(float amount) {
		if (amount<=0 || amount> Deposit_limit) {
			System.out.println("PLEASE DEPOSIT VALID AMOUNT ");
		
		}
	
	else {
		balance+= amount;//bal=bal+amt
		System.out.println("Rs."+amount+"is deposited successfully");
	}
	}
	@Override
	public void withdraw(float amount) {
		if (amount<=balance-MINBAL) {
			balance-=amount;
			System.out.println("RS."+amount+"withdrawn successfully");
		}
		else {
			System.out.println("insufficient balance");
		}
		
	}

	@Override
	public String toString() {
		return "SavingAccount [actNo=" + actNo + ", balance=" + balance + ", getName()=" + getName() + ", getCity()="
				+ getCity() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	

}
