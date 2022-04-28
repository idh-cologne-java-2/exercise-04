package idh.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Account {
	
	Bank bank;
	
	//for loop to search for account
	public void searchAccount() {
		for (Account account : bank) {
			System.out.println(account.accountBalance());
		}
	}
	
		String accountNumber;
		int accountBalance;
		
        //determination of account number and account balance
		Account(String i)
		{
			accountNumber = i;
			accountBalance = 300;
		}


		public boolean accountBalance()
		{
			System.out.println("Account number: " + accountNumber);
			System.out.println("account Balance:  " + accountBalance);
			return false;
		}
		
        //the user can withdraw an amount
		public void withdraw()
		{
			int temp;
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter amount to withdraw: ");
			temp = sc.nextInt();

			
			if(accountBalance - temp < 300)
				System.out.println("Minimum 300 account Balance is needed");
			else
			{
				accountBalance = accountBalance - temp;
				System.out.println("Current account Balance: " + accountBalance);
			}
		}

		//the user can enter an amount he/she wants to deposit to his/her account
		public void deposit()
		{
			int temp;
			Scanner sc = new Scanner(System.in);
		
			System.out.print("Enter amount to deposite: ");
			temp = sc.nextInt();

			accountBalance = accountBalance + temp;

			System.out.println("Current account Balance: " + accountBalance);
		}

		
        //the user is asked to enter his/her account number
		public void Create(ArrayList arr)
		{
			String str;
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter your account number: ");
			str = sc.next();

			Account ac = new Account(str);
			arr.add(ac);
		}
		
		public void delete(ArrayList arr)
		{
			String str;
			Scanner sc = new Scanner(System.in);
			Account ac = null;

			System.out.print("Enter your account number: ");
			str = sc.next();

			Iterator itr = arr.iterator();
			while(itr.hasNext())
			{
				Account a = (Account) itr.next();
				if(str.equals(a.accountNumber))
					ac = a;			
			}
		
			if(ac == null)
				System.out.println("Account not found");
			
		}
		
		
	}




