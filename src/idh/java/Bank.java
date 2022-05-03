package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account>{
	
	Account[] accounts = new Account[5];
	
	public Bank() {
		// create accounts with varying balances
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}

	@Override
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return new AccountIterator(this);
	}
	
	public int size() {
		return accounts.length;
	}
	
	public Account getAccount(int counter) {
		return accounts[counter];
	}

}
