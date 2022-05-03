package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Random;

public class ATM {
	
	// initial cash in the ATM
	int cash = 100;

	// accounts known to the ATM
	Account[] accounts = new Account[5];
	Bank bank;

	private String provider; //ATM-Betreibe

	public ATM(Bank bank) {
		this.provider = bank.getName();
		// create accounts with varying balances
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}
	
	public void iterateOverAccounts() {
		for(Account a : bank) {
			System.out.println(a.getId());
		}
	}
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, amount);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(int accountNumber, int amount) {
		// check for cash in the ATM
		if (amount > cash) {
			System.out.println("Sorry, not enough cash left.");
			return;
		}
		
		// check for existence of the account
		Account account = getAccount(accountNumber);
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
		Bank bank = new Bank("Cashgroup");
		ATM atm = new ATM(bank);
		atm.run();
	};
	
	/**
	 * Retrieves the account given an id.
	 * 
	 * @param id
	 * @return
	 */
	protected Account getAccount(int id) {
		
		
		//Aufgabe 1
		Iterator<Account> iter = new AccountIterator(accounts);
		while(iter.hasNext()) {
			Account a = iter.next();
//			System.out.println(a.getId());
			return a;
		}
		
//		for (Account account : accounts) {
//			if (account.getId() == id) 
//				return account;
//		}
		return null;
	}
	
	public class AccountIterator implements Iterator<Account> {

		Account[] a;
		int counter;
		
		public AccountIterator(Account[] a) {
			this.a = a;
			counter = 0;
			
		}
		
		@Override
		public boolean hasNext() {
			return counter < a.length;
		}

		@Override
		public Account next() {
			return a[counter++];
		}
		
	}

}
