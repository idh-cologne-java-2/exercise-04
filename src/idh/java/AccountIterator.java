package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	ATM atm ; 
	Account current ; 
	
	int counter; 
	
	public AccountIterator( ATM a) {
		
		atm = a; 
		counter = 0; 
	}

	
	@Override
	public boolean hasNext() {
		
		
	return counter < atm.size() ; 
	
	}
	
	@Override
	public Account next() {
		
		current = atm.getacc(counter);
		counter += 1;
		
		return current; 
	}
	
	
	
	

	
	
	
	

}
