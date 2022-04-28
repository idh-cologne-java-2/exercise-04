package idh.java;

import java.util.Iterator;
import java.util.Random;

// Zum speichern der Accounts
public class Bank implements Iterator<Account>{
	
	//accounts known to the bank
	Account[] accounts = new Account[5];
	
	String name;
	private int pos;
	
	public Bank(String name) {
		this.name = name;
		pos = 0;
		
		// create accounts with varying balances
		Random random = new Random();
		
		for (int i = 0; i < accounts.length; i++) { //hier auch Iterator?
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
		
	}
	
	public String getName() {
		return name;
	}
	
	
	@Override
	public boolean hasNext() {
		return pos < accounts.length;
	}

	@Override
	public Account next() {
		return accounts[pos++];
	}
	
	
	

	
	
	
}
