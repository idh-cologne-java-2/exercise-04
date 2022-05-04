package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	int p = 0;
	Account[] accounts;

	@Override
	public boolean hasNext() {
		return p < accounts.length;
	}

	@Override
	public Account next() {
		return accounts[p++];
	}

	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
	}

}
