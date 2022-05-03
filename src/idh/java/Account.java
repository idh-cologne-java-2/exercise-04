package idh.java;

/**
 * This class represents an account in our bank.
 * @author reiterns
 * @author alawal //modified
 *
 */
public class Account {

	int balance;
	int id;

	public Account(int id, int status) {
		this.id = id;
		this.balance = status;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int status) {
		this.balance = status;
	}
	
	/**
	 * Withdraws a sum of money from the account
	 * @param sum
	 */
	public void withdraw(int sum) {
		this.balance = balance - sum;
	}
	
	
}
