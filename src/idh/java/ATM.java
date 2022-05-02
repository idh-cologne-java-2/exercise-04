package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Iterator;

public class ATM implements Iterable<Account>{
	
	// initial cash in the ATM
	int cash = 100;
	Bank bank;

	// accounts known to the ATM
	//Account[] accounts = getBank();

	public ATM(String bankName) {
		bank = new Bank(bankName);
	}
	
	public Account getAccounts(int counter) {
		return bank.accounts[counter];
	}
	
	public int getSize() {
		return bank.accounts.length;
	}
	
	@Override
	public Iterator<Account> iterator() {
		
		return new AccountIterator(this);
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
		ATM atm = new ATM("Sparkasse");
		atm.run();
	};
	
	/**
	 * Retrieves the account given an id.
	 * 
	 * @param id
	 * @return
	 */
	protected Account getAccount(int id) {
		Iterator<Account> iter = iterator();
		Account test;
		while(iter.hasNext() == true) {
			test = iter.next();
			if (test.getId() == id)
				return test;
			}
			
			return null;
		
	}
}
