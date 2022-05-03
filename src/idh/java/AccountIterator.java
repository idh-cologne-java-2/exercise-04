package idh.java;

import java.util.Iterator;

	public class AccountIterator implements Iterator<Account> {

		//Referenz auf das worum es geht (Konten)
		Bank bank;
		//Z�hlervariable die normalerweise in der for-Schleife ist
		int checker;
		
		Account[] accounts;

		//Konstruktor f�r Referenz
		//wenn Iterator erzeugt, wei� er damit wozu er geh�rt
		public AccountIterator(Bank b) {
			bank = b;
			//wenn Iterator gebraucht wird dann auf 0 setzen (i = 0)
			checker = 0;

		}
		
		public AccountIterator(Account[] accounts) {
	        this.accounts = accounts;
	        this.checker = 0;
	    }


		@Override
		public boolean hasNext() {
			//Abbruchbedingung wenn der checker kleiner als die Gr��e
			return checker < bank.size();
		}

		@Override
		public Account next() {
			//n�chsten Account zur�ckgeben (i++)
			//wird auf a gespeichert, checker um 1 erh�hren und a zur�ckgeben
			Account a = bank.getNextAccount(checker);
			checker = checker + 1;
			return a;
		}

	}
