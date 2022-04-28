package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	private Account[] accounts;
	private int pos;
	
	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
		this.pos = 0;
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
