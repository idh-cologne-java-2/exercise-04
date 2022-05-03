package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {
	
	
	
	
	
	String bnkname;
	
	Account[] accounts = new Account[5];
	
	


	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator(this);
	}
	
	public void useaccount() {
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i + 1, random.nextInt(100));
		}
	}

}
