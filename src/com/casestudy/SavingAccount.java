package com.casestudy;

import com.Exception.LowBalance;

public class SavingAccount extends Account {
	public static double minBalance;
	static double interest;
	public SavingAccount(long acNo, String name, String uId, double balance, int pin) {
		super(acNo,name,uId,balance,pin);
	}
	static void min()
	{
		minBalance=10000;
		interest=0.05;
	}
	
	public void deposit(double amount)
	{
		balance=balance+amount;
		System.out.println("****Transection Success****");
		System.out.println("Deposited :"+amount);
	}
	public boolean withdraw(double amount)
	{
		double b=balance-amount;
		try {
				if(b>=minBalance)
				{
					balance=b;
					System.out.println("****Transection Success****");
					System.out.println("Withdraw :"+amount);
					return true;
				}
				else if(balance<=amount) 
				{
					throw new LowBalance();
				}
				else
				{
					System.out.println("Insuffient Balance to withdraw "+amount);
				}

		}
		catch(LowBalance e)
		{
			e.lowBalance(balance,amount);
		}
		return false;
	}
	public void calInterest()
	{
		int m=30;
		int y=365;
		double in=(this.balance*m*interest)/y;
		System.out.println(in+" Rs Per month in interest");
	}
	public void display()
	{
		super.display();
		System.out.println("MinBalance"+this.balance);
	}
	
	
}

