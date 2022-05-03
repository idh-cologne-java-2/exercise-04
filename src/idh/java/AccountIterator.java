package idh.java;
import java.util.Iterator;

public class AccountIterator implements Iterator<Account>{
	Bank sparkasse;
	int zaeler;
	
	public AccountIterator(Bank sparkasse) {
		this.sparkasse = sparkasse;
		zaeler = 0;
	}
	
	@Override
	public boolean hasNext() {
		return zaeler < sparkasse.size();
	}

	@Override
	public Account next() {
		return sparkasse.getAccount(zaeler++);
	}
	
}
