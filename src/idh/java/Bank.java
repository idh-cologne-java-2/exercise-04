package idh.java;
import java.util.Iterator;

public class Bank implements Iterable<Account> {
ATM atm;
	public Bank(ATM atm) {
		this.atm = atm;
		}
	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator(atm);
	}

}
