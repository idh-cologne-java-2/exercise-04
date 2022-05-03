package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account>{
	
	String bank;
	//Array mit den Accounts
	Account[] accounts = new Account[5];
	
	//Konstruktor für die Übergabe eines namens
	public Bank(String name) {
		this.bank = name;
		AccountsFill();
	}
	
	
	public void AccountsFill() {
		// create accounts with varying balances
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}
	
	public Account getNextAccount(int i) {
		return accounts[i];
	}
	
	public int size() {
		return accounts.length;
	}


	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator(this);
	}
}
