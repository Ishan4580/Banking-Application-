package com.casestudy;

import java.util.Calendar;

import com.Exception.LowBalance;

public class SalaryAccount extends SavingAccount {
	public static double minBalance;
	static double interest;
	String status;
	Calendar previous;
	public SalaryAccount(long acNo, String name, String uId, double balance, int pin) {
		super(acNo, name,uId, balance, pin);
		this.previous=Calendar.getInstance();
		this.status= "Open";
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Calendar getPrevious() {
		return previous;
	}


	public void setPrevious() {
		this.previous = Calendar.getInstance() ;
	}


	static void min()
	{
		minBalance = 0;
		interest=0.04;
	}
	
	public boolean withdraw(double amount)
	{
		int next=previous.get(Calendar.MINUTE);
		this.setPrevious();
		
		if(this.status.equals("Open"))
		{
		
		
			if(previous.get(Calendar.MINUTE)<next+1)
			{
				double b=balance-amount;
				try {
				if(b>=minBalance)
				{
					this.balance=b;
					System.out.println("Withdraw :"+amount);
					System.out.println("****Transection Success****");
					System.out.println("Time transection = "+previous.get(Calendar.HOUR)+":"+previous.get(Calendar.MINUTE));
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
					e.lowBalance(balance, amount);
				}
			}
			else
			{
				System.out.println("Your Account is Freeze");
				this.setStatus("Close");
			}
		}
		else
		{
			System.out.println("Your Account is Frozen");
		}
		return false;
		
	}
	public void deposit(double amount)
	{
//		if(this.status.equals("Open"))
//		{
//		int next=previous.get(Calendar.MINUTE);
//		this.setPrevious();
		
		
//			if(previous.get(Calendar.MINUTE)<next+1)
//			{
				this.balance=this.balance+amount;
				System.out.println("****Transection Success****");
				System.out.println("Deposited :"+amount);
//			}	
//			else
//				{
//					System.out.println("Your Account is Freeze");
//					this.setStatus("Close");
//				}
//		}
//		else
//		{
//			System.out.println("Your Account is Frozen");
//		}
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
