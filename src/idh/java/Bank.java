package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {
	
	Account[] accounts = new Account[5];
	
	public Bank() {
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++ ) {
					accounts[i] = new Account(i, random.nextInt(1000));
				}
	}

	@Override
	public Iterator<Account> iterator() {
		return  new AccountIterator(this);
	}
	
	public int size() {
		return accounts.length;
	}
	
	public Account gettheAccount(int i) {
		return accounts[i];
	}
	
	

}