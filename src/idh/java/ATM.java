package idh.java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;


public class ATM implements Iterable<Account>{
	
	// initial cash in the ATM
	int cash = 1000;
	Bank a;


	public ATM(String name) {
		a = new Bank(name);
	}
	
	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator(this);
	}
	
	public int size() {
		return a.accounts.length;
	}
	
	public Account getAccounts(int counter) {
		return a.accounts[counter];
	}
	
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Geben sie ihre Kontonummer ein: ");
				int accountNumber = Integer.parseInt(br.readLine());
				System.out.print("Gib ein und ich gebe aus: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, amount);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(int accountNumber, int amount) {
		// check for cash in the ATM
		if (amount > cash) {
			System.out.println("Entschuldigung, dieser Geldautomat is ‰rmer als du. \n");
			return;
		}
		
		// check for existence of the account
		Account account = getAccount(accountNumber);
		if (account == null) {
			System.out.println("Dieses Konto gibt es nicht. \n");
			return;
		}
		
		// check for balance of the account
		if (amount > account.getBalance()) {
			System.out.println("Entschuldigung, du bist zu arm. \n");
			return;
		}
		
		// withdraw
		account.withdraw(amount);
		cash -= amount;
		System.out.println("Ok, hier sind deine Moneten, genieﬂe! \n");

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM("Reiba");
		atm.run();
	};
	
	/**
	 * Retrieves the account given an id. HIER muss Iterator rein
	 * 
	 * @param id
	 * @return
	 */
	protected Account getAccount(int id) {
		Iterator<Account> iter = iterator();
		Account temp;
		while(iter.hasNext()) {
			temp = iter.next();
			if(temp.getId() == id) {
				return temp;
			}
		}
		return null;
	}

	



}
