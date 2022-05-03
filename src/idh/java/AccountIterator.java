package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	private Account[] accounts;
	Bank bank;
	int zaehler;
	
	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
		zaehler = 0;
	}
	
	public AccountIterator(Bank bank) {
		this.bank = bank;
		zaehler = 0;
	}

	@Override
	public boolean hasNext() {
		return zaehler < accounts.length;
	}

	@Override
	public Account next() {
		Account a = bank.getAccount(zaehler);
		zaehler = zaehler + 1;
		return a;
	}

}
