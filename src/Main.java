import java.util.Scanner;

import com.casestudy.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Bank bank=new Bank(5);
		int p;
		do
		{
			System.out.println("\n*****Welcome to Bank*****");
			System.out.println("1. Open Account");
			System.out.println("2. Login");
			
			 p=sc.nextInt();
			switch(p)
			{
				case 1:
					{
						bank.createAccount();
					}
					break;
				case 2:
					{
						bank.login();
					}
						break;
				case 10:
				{
					System.out.println("Exit");
				}
			}
		}while(p!=10);
		sc.close();
	}

}
