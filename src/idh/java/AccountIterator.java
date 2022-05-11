package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	int currentPosition = 0;
	Account[] accounts;
	
	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public boolean hasNext() {
		return currentPosition < accounts.length;
	}

	@Override
	public Account next() {
		return accounts[currentPosition++];
	}
	
}
