package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	private Bank bank;
	private int accountNumber;
	
	public AccountIterator(Bank bank) {
		this.bank = bank;
		this.accountNumber = 0;
	}

	@Override
	public boolean hasNext() {
		return this.accountNumber < this.bank.getAccountNumber();
	}

	@Override
	public Account next() {
		return this.bank.getAccountByNumber(this.accountNumber);
	}

}
