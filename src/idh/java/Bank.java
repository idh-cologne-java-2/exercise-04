package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {
	
	Account[] DKB = new Account[5];
	
public Bank(){
	
		// create accounts with varying balances
		Random random = new Random();
		for (int i = 0; i < DKB.length; i++) {
			DKB[i] = new Account(i, random.nextInt(1000));
		
	}
}

@Override
public Iterator<Account> iterator() {
	return new AccountIterator(DKB);
}	

}

