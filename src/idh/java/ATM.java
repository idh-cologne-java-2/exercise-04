package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
//import java.util.Random;

public class ATM {
	
	// initial cash in the ATM
	int cash = 100;
	
	//part of which bank
	String owner;

	// accounts known to the ATM
	Account[] accounts;

	public ATM(Bank bank) {
		//part of bank
		owner = bank.getName();
		
		// create accounts with varying balances
		
		
	}
	
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run(Bank bank) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, amount, bank);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(int accountNumber, int amount, Bank bank) {
		// check for cash in the ATM
		if (amount > cash) {
			System.out.println("Sorry, not enough cash left.");
			return;
		}
		
		// check for existence of the account
		Account account = getAccount(accountNumber, bank);
		if (account == null) {
			System.out.println("Sorry, this account doesn't exist.");
			return;
		}
		
		// check for balance of the account
		if (amount > account.getBalance()) {
			System.out.println("Sorry, you're out of money.");
			return;
		}
		
		// withdraw
		account.withdraw(amount);
		cash += amount;
		System.out.println("Ok, here is your money, enjoy!");

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		Bank bank1 = new Bank("Alliance");
		ATM atm = new ATM(bank1);
		atm.run(bank1);
	};
	
	/**
	 * Retrieves the account given an id.
	 * 
	 * @param id
	 * @return
	 */
	protected Account getAccount(int id, Bank bank) {
		
		
		Iterator<Account> aIter = bank;
		
		
		for (Account account : bank.getAccounts()) { //so implementieren oder auf bank direkt arbeiten?
			//System.out.println(account);
			account = aIter.next();
			if(account.getId() == id) {
				return account;
			}
		}
		
		//ehemals für AccountIterator
		/*
		while(aIter.hasNext()) {
			Account account = aIter.next();
			if(account.getId() == id) {
				return account;
			}
		}
		*/
		
		//Vorlage
		/*
		for (Account account : accounts) {
			if (account.getId() == id) 
				return account;
		}
		*/
		return null;
	}

}
