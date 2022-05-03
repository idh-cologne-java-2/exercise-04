package idh.java;

import java.util.Iterator;

public class Bank implements Iterable<BankAccount>{
	BankAccount[] AccountList;
	
	public BankAccount[] getAccountList() {
		return AccountList;
	}

	String BankName;
	
	public String getBankName() {
		return BankName;
	}

	public Bank(String BankName){
		this.BankName = BankName;
		
		BankAccount a1 = new BankAccount(67,134);
		BankAccount a2 = new BankAccount(33,687);
		BankAccount a3 = new BankAccount(73,354);
		BankAccount[] AccountList = {a1, a2, a3};
		
		this.AccountList = AccountList;
	}
	
	public BankAccount findAccount(int searchedID) {
		
		Iterator<BankAccount> iter = new AccountIterator(this);
		BankAccount LookAccount;
		
		while(iter.hasNext()) {
			
			LookAccount = (BankAccount) iter.next();
			
			if(LookAccount.getAccountID() == searchedID) {
				return LookAccount;
			}
		}
		return null;
	}

	@Override
	public Iterator<BankAccount> iterator() {
		
		return new AccountIterator(this);
	}
	
}
