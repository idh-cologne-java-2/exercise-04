package idh.java;

import java.util.Iterator;

public class BankIterator implements Iterator<Account> {
	
	Bank b;
	int counter;
	
	public BankIterator(Bank bank) {
		b = bank;
		counter = 0;
	}

	@Override
	public boolean hasNext() {
		return counter < b.size();
	}

	@Override
	public Account next() {
		return b.getAccount(counter++);
	}

	
}
