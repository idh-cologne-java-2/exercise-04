package idh.java;

import java.util.Iterator;

	public class AccountIterator implements Iterator<Account> {

		//Referenz auf das worum es geht (Konten)
		Bank bank;
		//Zählervariable die normalerweise in der for-Schleife ist
		int checker;
		
		Account[] accounts;

		//Konstruktor für Referenz
		//wenn Iterator erzeugt, weiß er damit wozu er gehört
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
			//Abbruchbedingung wenn der checker kleiner als die Größe
			return checker < bank.size();
		}

		@Override
		public Account next() {
			//nächsten Account zurückgeben (i++)
			//wird auf a gespeichert, checker um 1 erhöhren und a zurückgeben
			Account a = bank.getNextAccount(checker);
			checker = checker + 1;
			return a;
		}

	}
