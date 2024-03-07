package com.casestudy;


import java.time.LocalDateTime;

public class DailyReport {
	long acno;
	LocalDateTime time;
	String activity;
	double amount;
	String accountType;
	public DailyReport(long acno,LocalDateTime time, String activity, double amount,String accouttype) {
		this.acno = acno;
		this.time=time;
		this.activity = activity;
		this.amount = amount;
		this.accountType = accouttype;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public long getAcno() {
		return acno;
	}
	public void setAcno(long acno) {
		this.acno = acno;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public void display()
	{
		System.out.println("\nAccount No: "+this.acno);
		System.out.println("Time: "+this.time);
		System.out.println("Activity: "+this.activity);
		System.out.println("Amount: "+this.amount);
		System.out.println("Account Type: "+this.accountType);
	}
	
}
