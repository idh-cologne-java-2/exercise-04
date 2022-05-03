package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {
		@Override
		public Iterator<Account> iterator() {
			// TODO Auto-generated method stub
			return (Iterator<Account>) new AccountIterator(this);
		}
		
	private String bank;
	private Account[] Currentbank = new Account[5];  
	
	
	//füllt bank mit Accounts
	public Bank(String bank ) {
		this.bank = bank; 
		fillAcc();
		
	}
	
	public void fillAcc() {
		
		
		Random s = new Random();
		for(int i = 0; i< Currentbank.length; i++) {
			Currentbank[i] = new Account(i, s.nextInt(1000));
		}
	}
	
	
	public void SetCurrentbank(Account[] ac ) {
		
		this.Currentbank = ac ;  
	}
	
	public Account[] getCurrentbank() {
		
		return Currentbank; 
	}
	
	public void SetName( String name) {
		this.bank = name ; 
	}
	
	public String getName() {
		return bank; 
	}
}
	
