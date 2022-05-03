package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	Bank bank; // Referenz auf Bank
	int counter; // Zählervariable
	
	// Konstruktor
	public AccountIterator(Bank bank) {
		// TODO Auto-generated constructor stub
		this.bank = bank;
		counter = 0; 
	}

	// Abbruchbedingung
	@Override 
	public boolean hasNext() {		
		return counter < bank.size();
	}

	// Iteration
	@Override
	public Account next() {
		Account a = bank.getAccount(counter);
		counter = counter + 1;
		return a;
		
		//return bank.getAccount(counter++);
	}
	

}
