package idh.java;

public class Main {

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		Bank bank = new Bank();
		ATM atm = new ATM(bank);
		atm.run();
	};
}
