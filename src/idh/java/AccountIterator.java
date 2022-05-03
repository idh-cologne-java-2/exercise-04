package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<BankAccount> {

	BankAccount[] AccountList;
	int counter = 0;
	
	AccountIterator(Bank AccountList){
		this.AccountList = AccountList.getAccountList();
	}
	
	@Override
	public boolean hasNext() {
		return counter < AccountList.length;
	}

	@Override
	public BankAccount next() {
		BankAccount nextAccount = AccountList[counter];
		counter++;
		return nextAccount;
	}

}
