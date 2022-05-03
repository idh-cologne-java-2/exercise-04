package idh.java;

import java.util.Iterator;


public class AccountIterator implements Iterator<Account> {
ATM atm;
int i;

public AccountIterator(ATM atm) {
i= 0;
this.atm = atm;
}
	@Override
	public boolean hasNext() {
		return  i < atm.accounts.length;
	}

	@Override
	public Account next() {
		return atm.accounts[i++];	
	}

}
