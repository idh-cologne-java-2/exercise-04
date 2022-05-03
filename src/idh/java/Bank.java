package idh.java;
import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account>{
	Account[] accounts = new Account[5];
	
	public Bank() {
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}
	
	public int size() {
		return accounts.length;
	}
	
	public Account getAccount(int account) {
		return accounts[account];
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		Iterator<Account> iter = new AccountIterator(bank);
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator(this);
	}

}
