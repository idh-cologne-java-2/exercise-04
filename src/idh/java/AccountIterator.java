package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	int checker;
	int counter;
	int variable = 0;
	Bank Volksbank;
	
	Account[] accounts;
	
	public AccountIterator(Bank bank) {
		this.Volksbank = bank;
	}
	public AccountIterator(Account[] accounts) {
        this.accounts = accounts;
        this.checker = 0;
	}

	@Override
	public boolean hasNext() {
		return variable < Volksbank.size();
	}

	@Override
	public Account next() {
		Account a = Volksbank.gettheAccount(counter);
		counter = counter + 1;
		
		return a /*Volksbank.gettheAccount(variable++) */;
	}
	
	
	

}
