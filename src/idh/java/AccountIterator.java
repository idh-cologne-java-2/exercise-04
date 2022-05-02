package idh.java;

import java.util.Iterator;
import java.util.ArrayList;

public class AccountIterator implements Iterator<Account> {
		
	public static void main(String args[]) {
		ArrayList <String> account = new ArrayList<String>();
		account.add("123");
		account.add("345");
		account.add("678");
		account.add("901");
	
		Iterator<String> iterator = account.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());;
			}
		}
	
				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return false;
				}
				@Override
				public Account next() {
					// TODO Auto-generated method stub
					return null;
				}
}
