package com.tnsif.thirteen.synchronization;

public class SynchronizationDriver {

	public static void main(String[] args) throws InsufficientBalanceException{
Account isha=new Account(1001, "ISHA", 45000);
		
		System.out.println(isha);
		//isha.withdraw(7865);
		
		AccountThread t[]=new AccountThread[10];
		for(int i=0;i<10;i++)
		{
			t[i] = new AccountThread(isha, 1000 * (i+1));
		}
		try {
			for(int i=0;i<10;i++)
			{
				t[i].join();
			}
		}
		catch(InterruptedException e)
		{
			System.err.println(e.getMessage());
		}
		
		System.out.println("----------------------");
		System.out.println(isha);
		

	}
		
	}

