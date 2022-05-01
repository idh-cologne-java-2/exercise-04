package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account>{

		ATM automat;
		int counter;
		Bank bank;
	
		public AccountIterator(ATM a) {
			automat = a;
			counter = 0;
		}
		
	
		public AccountIterator(Bank bank) {
			this.bank = bank;
			counter = 0;
		}




	@Override
	public boolean hasNext() {
		return counter < automat.size();
	}

	@Override
	public Account next() {
		Account x = automat.getAccounts(counter);
		counter++;
		return x;
	}

}
