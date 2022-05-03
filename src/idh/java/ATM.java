package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Random;


public class ATM {

	// initial cash in the ATM
	int cash = 1000;
	//Referenz auf das worum es geht
	Bank bank;
	
	Account[] accounts = new Account[5];
	
	//Methode die den Namen der Bank in einem neuen Objekt erstellt
	public ATM(String name) {
		bank = new Bank (name);
	}
	
	public ATM() {
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}
	
	//ATM den Account übergeben der an der Stelle checker liegt
	public Account whichAccount(int checker) {
		return bank.accounts[checker];
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
				System.out.println("Guthaben: " + getAccount(accountNumber).balance);
				//System.out.println("Guthaben:" + getAccountWithIterator(accountNumber).balance);
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
		// Aufgabe 1: Account account = getAccountWithIterator(accountNumber);
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
		ATM atm = new ATM("Coole Bank");
		ATM atm2 = new ATM();
		atm.run();
		//atm2.run();
	};

	/**
	 * Retrieves the account given an id.
	 *
	 * @param id
	 * @return
	 */
	protected Account getAccount(int id) {
		for (Account account : bank) {
			if (account.getId() == id)
				return account;
		}
		return null;
	}
	
	protected Account getAccountWithIterator(int id) {
		//über Accounts iterieren
		//da man nicht weiß wie viele Accounts der ATM hat, einfach immer gucken ob es noch eine Account danach gibt
		Iterator<Account> iter = new AccountIterator(accounts);
		while (iter.hasNext()) {
			if (iter.next().getId() == id) {
				System.out.println(iter.next());
				return iter.next();
				}
		}
		return null;
	}



	
}	
