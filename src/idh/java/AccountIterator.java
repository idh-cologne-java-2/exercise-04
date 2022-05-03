package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	Bank sparkasse;
	int zaehlervariable = 0;

	public AccountIterator(Bank bank) {
		this.sparkasse = bank;
	}

	@Override
	public boolean hasNext() {
		return zaehlervariable < sparkasse.size();
	}

	@Override
	public Account next() {
		return sparkasse.gettheAccount(zaehlervariable++);
	}
	
}
