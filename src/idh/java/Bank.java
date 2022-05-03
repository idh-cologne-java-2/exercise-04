package idh.java;

import java.util.Iterator;

import java.util.Random;

public class Bank implements Iterable<Account>{
		
	//accounts 
	Account[] accounts = new Account[5];

	
	public Bank() {
		//create accounts
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(2000));
		}
	}
	
	
	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator(this);
	}
	
	public int size() {
		return accounts.length;
	}
	
	public Account gettheAccount(int zaehler) {
		return accounts[zaehler];
	}

// create accounts
//	public void fillAcc() {
//		Random r = new Random();
//		for(int i = 0; i < accounts.length; i++) {
//			accounts[i] = new Account(i+1, r.nextInt(1000));
//		}
//	}


}