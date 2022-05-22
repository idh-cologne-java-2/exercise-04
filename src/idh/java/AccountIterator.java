package idh.java;
import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	//zaehlervariable an der position 0
int zvar = 0;
Account[] accounts;
public AccountIterator(Account[] accounts) {
	accounts = this.accounts;
}

@Override
public boolean hasNext() {
	return zvar < accounts.length;
}

@Override
public Account next() {
	return accounts[zvar++];
}
}
