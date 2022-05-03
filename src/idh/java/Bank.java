package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {
	
	Account[] accounts = new Account[5];
	String name;
	
	public Bank(String name) {
		this.name = name;
		accountCreator();
	}
	
	public Iterator<Account> iterator() {

		Iterator<Account> accountIterator = new AccountIterator(accounts);
		return accountIterator;
	}
	
	public Account getAccount(int i) {
		return accounts[i];
	}
	
	
	public void accountCreator() {
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}

}
