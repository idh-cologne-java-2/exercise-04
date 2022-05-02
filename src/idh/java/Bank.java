package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account>{
	
	String bankName;
	
	//accounts 
	Account[] accounts = new Account[5];

	
	public Bank(String name) {
		this.bankName = name;
		fillAcc();
	}
	
	
	@Override
	public Iterator<Account> iterator() {
	
		return new AccountIterator(this);
	}

// create accounts
	public void fillAcc() {
		Random r = new Random();
		for(int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i+1, r.nextInt(1000));
		}
	}


}
