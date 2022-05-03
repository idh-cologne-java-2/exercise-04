package idh.java;

import java.util.Iterator;

public class Bank implements Iterable<Account>{
	
	Account[] members;
	int nextPos = 0;
	private String name;
	
	public Bank(String name) {
		this.members = new Account[10];
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addMember(int id, int status) throws Exception {
		if (nextPos < members.length)
			members[nextPos++] = new Account(id, status);
		else
			throw new Exception("Reached maximum capacity");
	}
	
	public int size() {
		return members.length;
	}
	
	public Account getMember(int memberId) {
		return members[memberId];
	}
	
	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator(this);
	}
	
	public class AccountIterator implements Iterator<Account> {

		Bank bank;
		int counter;
		
		public AccountIterator(Bank b) {
			bank = b;
			counter = 0;
			
		}
		
		@Override
		public boolean hasNext() {
			return counter < bank.size();
		}

		@Override
		public Account next() {
			return bank.members[counter++];
		}
		
	}


	
}
