package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {

	
	String bankname;
	
	// accounts known to the ATM
	Account[] accounts = new Account[5];
	
	
	public Bank(String name) {
		this.bankname = name;
		moneten();
	}


	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator(this);
	}
	
	
	public void moneten() {
		// create accounts with varying balances
				Random random = new Random();
				for (int i = 0; i < accounts.length; i++) {
					accounts[i] = new Account(i+1, random.nextInt(1000));
				}
	}
	
}
