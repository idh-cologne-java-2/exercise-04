package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {

	// accounts known to the ATM
		Account[] accounts = new Account[5];
		
		public Bank() {
			// create accounts with varying balances
			Random random = new Random();
			for (int i = 0; i < accounts.length; i++) {
				accounts[i] = new Account(i, random.nextInt(1000));
			}
		}
		
		public Account getAccount(int account) {
			return accounts[account];
		}

		@Override
		public Iterator<Account> iterator() {
			return new BankIterator(this);
		}

		public int size() {
			return accounts.length;
		}
		
		public static void main(String[] args) {
			Bank volksbank = new Bank();
			Iterator<Account> bankiterator = new BankIterator(volksbank);
			while(bankiterator.hasNext()) {
				System.out.println(bankiterator.next());
			}
		}
}
