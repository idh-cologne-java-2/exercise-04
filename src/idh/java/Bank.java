package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {

	Account[] accounts;

	public Bank(Account[] accounts) {
		super();
		this.accounts = accounts;
	}

	public void SearchAccounts() {
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}

	@Override
	public Iterator<Account> iterator() {
		return new Iterator<Account>() {

			private int counter = 0;

			@Override
			public boolean hasNext() {
				return counter < accounts.length;
			}

			@Override
			public Account next() {
				return accounts[counter++];
			}
		};
	}

}
