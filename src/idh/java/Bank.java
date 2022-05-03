package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {
	@Override
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return new AccountIterator(this);
	}
	
	private Account[] Currentbank = new Account[5];  
	
	public Bank() {
		fillAcc();
	}
	
	public void fillAcc() {
		Random s = new Random();
		for(int i = 0; i< Currentbank.length; i++) {
			Currentbank[i] = new Account(i, s.nextInt(1000));
		}
	}
	
	
	public void SetCurrentbank(Account[] s ) {
		this.Currentbank = s ;  
	}
	
	public Account[] getCurrentbank() {
		return Currentbank; 
	}

	

	
	
	
	
	
	

}