package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	ATM atm;
	Bank bank;
	int counter;
	
	public AccountIterator(ATM a) {
		atm = a;
		counter = 0;
	}
	
	public AccountIterator(Bank b) {
		this.bank = b;
		counter = 0;
	}	
	
	
	@Override
	public boolean hasNext() {
		
		return counter < atm.getSize();
	}

	@Override
	public Account next() {
		Account x = atm.getAccount(counter);
		counter++;
		
		return x;
	}

}
