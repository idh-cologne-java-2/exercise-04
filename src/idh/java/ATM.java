package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	// initial cash in the ATM
	int cash = 100;
	Bank sparkasse = new Bank();
	
	
public static void main(String[] args) {
		
		ATM atm = new ATM();
		
		atm.run();
	
		
	};
	
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
	
	protected Account getAccount(int id) {
		for (Account account : sparkasse) {
			if (account.getId() == id) 
				return account;
		}
		return null;
	}

}