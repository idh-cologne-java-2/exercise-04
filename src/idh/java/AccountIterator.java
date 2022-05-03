package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	Bank bank;
	ATM atm;
	int zaehler;
	
	public AccountIterator(ATM s) {
		atm = s;
		zaehler = 0;
	}
	
	public AccountIterator(Bank t) {
		this.bank = t;
		zaehler = 0;
	}

	@Override
	public boolean hasNext() {
		return zaehler < atm.getSize();
		
	}

	@Override
	public Account next() {
		Account v = atm.getAccount(zaehler);
		zaehler++;
		return v;
	}

}
