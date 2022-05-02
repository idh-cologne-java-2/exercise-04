package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	Bank bank;
	int counter;
	
	public AccountIterator(Bank bank) {
		this.bank = bank;
		counter = 0;
	}
	
	@Override
	public boolean hasNext() {
		return counter < bank.size();
	}

	@Override
	public Account next() {
		return bank.getAccount(counter++);
	}

}
