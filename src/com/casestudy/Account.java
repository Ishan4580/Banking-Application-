package com.casestudy;


public abstract class Account {
	long acNo;
	String name;
	String uId;
	double balance;
	int pin;

	
	public Account(long acNo, String name, String uId, double balance, int pin) {
		super();
		this.acNo = acNo;
		this.name = name;
		this.uId = uId;
		this.balance = balance;
		this.pin = pin;
	}
	

	public long getAcNo() {
		return acNo;
	}


	public void setAcNo(long acNo) {
		this.acNo = acNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getuId() {
		return uId;
	}


	public void setuId(String uId) {
		this.uId = uId;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public int getPin() {
		return pin;
	}


	public void setPin(int pin) {
		this.pin = pin;
	}


	abstract boolean withdraw(double amount);

	abstract void deposit(double amount);
	
	abstract public void calInterest();
	
		
	
	void display()
	{
		System.out.println("The Account No: "+this.acNo);
		System.out.println("Holder Name: "+this.name);
		System.out.println("User Id: "+this.uId);
		System.out.println("The Account Balance: "+this.balance);
		System.out.println("The Pin: "+this.pin);
	}

}

