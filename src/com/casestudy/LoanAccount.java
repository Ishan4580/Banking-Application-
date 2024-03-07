package com.casestudy;

import java.util.Scanner;

import com.Exception.LowBalance;

public class LoanAccount extends Account {
		double rePaid;
		static double interest; 
		public LoanAccount(long acNo, String name, String uId, double balance, int pin) {
			super(acNo,name,uId,balance,pin);
			this.rePaid = 0;
		}
		
		static void set()
		{
			interest=14;
		}
		public double getRePaid() {
			return rePaid;
		}

		public void setRePaid(double rePaid) {
			this.rePaid = rePaid;
		}
		public boolean withdraw(double amount)
		{
			try {
				if(this.balance<0)
				{
					System.out.println("You Can not Withdraw");
				}
				else if(this.balance<=amount)
				{
					throw new LowBalance();
				}
				else
				{
					balance=balance-amount;
					System.out.println("****Transection Success****");
					System.out.println("Withdraw :"+amount);
					return true;
				}
			}
			catch(LowBalance e)
			{
				e.lowBalance(balance, amount);
			}
			return false;
		}
		public void deposit(double amount)
		{
			System.out.println("****Transection Success****");
			double an=this.balance+amount;
			this.balance=an;
			this.rePaid= this.rePaid+amount;
		}
		public void calInterest()
		{
			Scanner sc=new Scanner(System.in);
			int flag=0;
			int term;
			do
			{
			System.out.println("The Loan Term is 2 Year or 5 Year");
			 term=sc.nextInt();
				if(term == 2 || term == 5)
				{
					flag=0;
				}
				else
				{
					flag++;
					System.out.println("Invalid Term");
				}
			}while(flag!=0);
			double interst=this.balance*interest*term;
			System.out.println("Total rate of Interset Loan Amount"+interst);
			System.out.println("Total amount after rate of interst is :"+(this.balance+interst));
			sc.close();
		}
		public void display()
		{
			super.display();
			System.out.println("MinBalance"+this.rePaid);
		}
}
