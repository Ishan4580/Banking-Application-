package com.casestudy;

import com.Exception.LowBalance;

public class CurrentAccount extends Account {
		 public  double overdraft;
static double interest;
		public CurrentAccount(long acNo, String name, String uId, double balance, int pin,double overdraft) {
			super(acNo,name,uId,balance,pin);
			this.overdraft=overdraft;
		}

		public double getOverdraft() {
			return overdraft;
		}
		public void setOverdraft(double overdraft) {
			this.overdraft = overdraft;
		}
		static void setinterest()
		{
			interest=0;
		}
		boolean withdraw(double amount)
		{
			
			if(this.balance>=this.overdraft)
			{
				double a=this.balance-amount;
				try {
					if(a>=this.overdraft)
					{
						this.balance=a;
						System.out.println("****Transection Success****");
						System.out.println("Withdraw :"+amount);			
						return true;
					}
					else
					{
						throw new LowBalance();
					}
				}
				catch(LowBalance e)
				{
					e.lowBalance(balance, amount);
				}
			}	
			else
			{
				System.out.println("You have reached your Overdraft Limit");
				return false;
			}
			return false;
			
		}
		void deposit(double amount)
		{
			System.out.println("****Transection Success****");
			double am=this.balance+amount;
			if(this.balance == overdraft)
			{
				this.balance=am;
				
			}
			else
			{
				this.balance=am;
			}
		}
		public  void calInterest()
		{
			
			 System.out.println("No Interest Rate");
			
		}
		public void display()
		{
			super.display();
			System.out.println("Overdraft Limit is :"+this.overdraft);
		}
		
		}
