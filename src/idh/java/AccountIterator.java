package idh.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AccountIterator implements Iterator<Account>{

	
	public static void main(String[] args)
	{
		ArrayList<Account>arr = new ArrayList<Account>();
		Scanner sc = new Scanner(System.in);
		String str;
		int op;
		Account ac = null;
		Account a = new Account(null);
        
		//definition of five account numbers
		arr.add(new Account("123"));
		arr.add(new Account("345"));
		arr.add(new Account("567"));
		arr.add(new Account("789"));
		arr.add(new Account("901"));
		

		System.out.print("Enter your account number: ");
		str = sc.next();

		Iterator itr = arr.iterator();
		while(itr.hasNext())
		{
			a = (Account) itr.next();
			if(str.equals(a.accountNumber))
				ac = a;
		}
		
        //if the account number does not match the five account numbers, the user will be informed
		// that the account number does not exist
		if(ac == null)
		{
			System.out.println("Invalid account number");
			System.exit(0);
		}
		else
		{
		
		//the user has four options for what he/she can do with his/her account
		do
		{
			System.out.println("Press 1 - for current account Balance");
			System.out.println("Press 2 - for Withdraw");
			System.out.println("Press 3 - for Deposit");
			System.out.println("Press 0 - for Exit");
		
			System.out.print("Enter your choice => ");
			op = sc.nextInt();
		
				switch(op)
				{
					case 1:
						ac.accountBalance();
						break;
					case 2:
						ac.withdraw();
						break;
					case 3:
						ac.deposit();
						break;
					case 4:
					
					case 0:
					System.out.println("Thank you! Until next time :)");
						break;
					default:
					System.out.println("Invalid input");
				}
			}while(op != 0);
		}
}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account next() {
		// TODO Auto-generated method stub
		return null;
	}

}
