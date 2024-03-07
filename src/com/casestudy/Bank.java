package com.casestudy;

import java.time.LocalDateTime;
import java.util.Scanner;



public class Bank {
		int size;
		int index;
		int d;
		Account [] account;
		DailyReport [] dr;
		public Bank(int size) {
			this.size=size;
			this.index=-1;
			this.account=new Account [size];
			this.dr=new DailyReport[50];
			this.d=0;
		}
		Scanner sc=new Scanner(System.in);
		
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public void createAccount()
		{
			int p=0;
			long acno=1357924680;

			
				System.out.println("\n1. Current Account");
				System.out.println("2. Saving Account");
				System.out.println("3. Salary Account");
				System.out.println("4. loan Account");
				 p=sc.nextInt();
				switch(p)
				{
					case 1:
					{
						int flag=0,pin =0;
						String nm,uid;
						double b=0,od=0;
						
								System.out.println("Enter the name");
								sc.nextLine();
								 nm=sc.nextLine();
								 do {
										 System.out.println("Enter User Id");
										 uid=sc.nextLine();
										 if(findAcNO(uid)!= -1)
										 {
											
											 System.out.println("User id Already use");
											 flag++;
										 }
								 }while(flag!=0);
								System.out.println("Enter the Balance");
								 b=sc.nextDouble();
								do {
									System.out.println("Enter the 4 Digit Pin");
										 pin=sc.nextInt();
										if(pin>=9999 || pin<=999)
										{
											flag++;
											System.out.println("Pin is Invalid");
										}
										else
										{
											flag=0;
										}
							}while(flag!=0);

									System.out.print("Enter the Overdraft Limit:");
									 od=sc.nextDouble();
										double a=0-od;
								account[++index]=new CurrentAccount(acno,nm,uid,b,pin,a);
								System.out.println("******Your Current Account is Open******");
								account[index].display();
								dr[d]=new DailyReport(acno,LocalDateTime.now(),"Open",b,"Current");
								d++;
								acno++;
						
					}
						break;
					case 2:
						{
							int  pin;
							String nm,uid;
							double b;
							int flag=0,count=0;
								System.out.println("Enter the name");
								sc.nextLine();
								 nm=sc.nextLine();
								 do {
									 System.out.println("Enter User Id");
									 uid=sc.nextLine();
									 if(findAcNO(uid)!= -1)
									 {
										
										 System.out.println("User id Already use");
										 flag++;
									 }
							 }while(flag!=0);
								do
								{
									System.out.println("Enter the Balance");
									  b=sc.nextDouble();
									  if(b<=10000)
									  {
										  flag++;
										  System.out.println("Invaild Balance");

									  }
									  else
									  {
										  flag=0;
									  }
								}while(flag!=0);
								do
								{
									System.out.println("Enter the 4 Digit Pin");
									pin=sc.nextInt();
									if(pin>=9999 || pin<=999)
									{
										count++;
										System.out.println("Pin is Invalid");
									}
									else
									{
										count=0;
									}

								}while(count!=0);	
								account[++index]=new SavingAccount(acno,nm,uid,b,pin);
								System.out.println("*****Your Saving Account is Open*****");
								account[index].display();
								dr[d]=new DailyReport(acno,LocalDateTime.now(),"Open",b,"Saving");
								d++;
								acno++;
						}
						break;
					case 3:
					{
						int flag=0,pin =0;
						String nm,uid;
						double b=0;
						
								System.out.println("Enter the name");
								sc.nextLine();
								 nm=sc.nextLine();
								 do {
									 System.out.println("Enter User Id");
									 uid=sc.nextLine();
									 if(findAcNO(uid)!= -1)
									 {
										 
										 System.out.println("User id Already use");
										 flag++;
									 }
							 }while(flag!=0);
								do {
									System.out.println("Enter the 4 Digit Pin");
										 pin=sc.nextInt();
										if(pin>=9999 || pin<=999)
										{
											flag++;
											System.out.println("Pin is Invalid");
										}
										else
										{
											flag=0;
										}
							}while(flag!=0);

								account[++index]=new SalaryAccount(acno,nm,uid,0,pin);
								System.out.println("******Your Salary Account is Open******");
								account[index].display();
								dr[d]=new DailyReport(acno,LocalDateTime.now(),"Open",b,"Salary");
								d++;
								acno++;
					}			break;
						case 4:
							{
								int flag=0,pin =0;
								String nm,uid;
								double b=0;

								System.out.println("Enter the name");
								sc.nextLine();
								 nm=sc.nextLine();
								 do {
									 System.out.println("Enter User Id");
									 uid=sc.nextLine();
									 if(findAcNO(uid)!= -1)
									 {
										 System.out.println("User id Already use");
										 flag++;
									 }
									 else
									 {
										 flag=0;
									 }
							 }while(flag!=0);
								System.out.println("Enter the Loan Amount");
								 b=sc.nextDouble();
								do {
									System.out.println("Enter the 4 Digit Pin");
										 pin=sc.nextInt();
										if(pin>=9999 || pin<=999)
										{
											flag++;
											System.out.println("Pin is Invalid");
										}
										else
										{
											flag=0;
										}
							}while(flag!=0);

									double lo=0-b;
										
								account[++index]=new LoanAccount(acno,nm,uid,lo,pin);
								System.out.println("******Your Loan Account is Open******");
								dr[d]=new DailyReport(acno,LocalDateTime.now(),"Open",lo,"Loan");
								d++;
								account[index].display();
								acno++;

							}
							break;
						case 10:
						{
							System.out.println("Go To Back Page");
						}
						break;
					default :
					{
						System.out.println("Invalid");
					}
				}
				
		}
		
		
		
private int  findAcNO(String  uid) {
	for(int i=0;i<=index;i++)
	{
		if(account[i].uId.equalsIgnoreCase(uid))
		{
			return i;
		}
		
	}
	return -1;
}
		
public void display(int i)
{
	account[i].display();
}


public void dailyReport()
{
	if(d != -1)
	{
		for(int i=0;i<d;i++)
		{
			dr[i].display();
		}
	}
}
public void login()
{
	System.out.println("Enter the User Id");
	sc.nextLine();
	String uid=sc.nextLine();
	if(uid.equals("manager123"))
	{

		System.out.println("Enter the 4 Digit Pin");
		int pi=sc.nextInt();
		if(pi==0000)
		{
		
			int p=0;
				while(p!=3) {
					System.out.println("1. Daily Report");
					System.out.println("2. All Account Details");
					 p=sc.nextInt();
					switch(p)
					{
					case 1:
					{
							this.dailyReport();
						
					}
						break;
					case 2:
					{
						
						for(int ab=0;ab<=getIndex();ab++)
						{
							this.display(ab);
						}	
					}
					break;
				}
			}	
	}
		else
		{
			System.out.println("Pin is Invalid");
		}
	}
	else
	{	
	int res=findAcNO(uid);
	int flag=0;int choice=0;
	if(res == -1)
	{
		System.out.println("*****Invaild User Id*****");
	}
	else
	{
		do
		{
			System.out.println("Enter the 4 Digit Pin");
			int pin=sc.nextInt();
			if(account[res].pin== pin)
			{
				System.out.println("*****Login SuccessFul****");
				break;
			}
			else
			{
				flag++;
				System.out.println("*****Invalid Pin****");
			}
		}while(flag!=3);	
		
		
			
		
			System.out.println("1. Withdraw");
			System.out.println("2. Deposit");
			System.out.println("3. Intrest");
			System.out.println("4. Delete Account");
			System.out.println("5. Log Out");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:
				{
					System.out.print("Enter the Amount:");
					double amount=sc.nextDouble();
					boolean a= account[res].withdraw(amount);
					System.out.println("Your Balance is: "+account[res].balance);
					if(a== true)
					{
					dr[d]=new DailyReport(account[res].acNo,LocalDateTime.now(),"Withdraw",amount,account[res].getClass().getSimpleName());
					d++;
					}	
				}
				break;
				case 2:
					{
					System.out.print("Enter the Amount:");
					double amount=sc.nextDouble();
					account[res].deposit(amount);
					dr[d]=new DailyReport(account[res].acNo,LocalDateTime.now(),"Deposit",amount,account[res].getClass().getSimpleName());
					System.out.println("Your Balance is: "+account[res].balance);
					d++;
					}
					break;
				case 3:
					{
					account[res].calInterest();
					}
					break;
				case 4:
				{
					dr[d]=new DailyReport(account[res].acNo,LocalDateTime.now(),"Close",0,account[res].getClass().getSimpleName());
					d++;
					while(res<index)
					{
						account[res]=account[res+1];
						res++;
					}
					index--;
					System.out.println("Account is Deleted...");
				}
				break;
				case 5:
				{
					System.out.println("Log Out");
				}
			}
	
		
		
	}
	}
		 
	}

}


































