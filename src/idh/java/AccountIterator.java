package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	ATM atm ; 
	Bank bank;
	Account current ; 
	
	int counter =0; 
	
	public AccountIterator( ATM a) {
		
		atm = a; 
		counter = 0; 
	}
	public AccountIterator(Bank b) {
		this.bank = b;
		counter = 0; 
	}

	
	@Override
	public boolean hasNext() {
		return counter < atm.getSize() ; 
	}
	
	@Override
	public Account next() {
		current = atm.getAcc(counter);
		counter += 1;
		return current; 
	}
	
	
	
	

	
	
	
	

}