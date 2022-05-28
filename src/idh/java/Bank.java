package idh.java;
import java.util.Random;

public class Bank implements Iterable<Account> {

	/** accounts known to the bank */
	private Account[] accounts = new Account[1];
	
	public Bank() {
		this.accounts[0] = new Account(0,0);
	}

	@Override
	public AccountIterator iterator() {
		// TODO Auto-generated method stub
		return new AccountIterator(this);
	}
	
	public void createNewAccount() {
		int currentNumberOfAccounts = accounts.length;
		Account[] temp = new Account[currentNumberOfAccounts + 1];
		for (int i = 0; i < currentNumberOfAccounts; i++) {
			temp[i] = accounts[i];
		}
		Random rnd = new Random();
		int newId = rnd.nextInt();
		temp[currentNumberOfAccounts] = new Account(currentNumberOfAccounts,newId);
		accounts = temp;
		return;
	}
	
	public int getAccountNumber() {
		return accounts.length;
	}
	
	public Account getAccountByNumber(int number) {
		if (number < this.accounts.length) {
			return this.accounts[number];
		}
		return null;
	}
	
}
