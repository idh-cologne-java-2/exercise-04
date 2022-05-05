package idh.java;
// Tim Schäfer 7380391
import java.io.*;
import java.util.Iterator;

public class ATM {
	
	Bank BankOfATM;
	BankAccount aktivAccount;
	int moneyInATM;
	
	public ATM(Bank BankofATM,int moneyInATM) {
		this.BankOfATM = BankofATM;
		this.moneyInATM = moneyInATM;
	}
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	public void run() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				
				// asking for the ID
				System.out.print("Welcome by "+BankOfATM.getBankName() +"\nEnter your Accound-ID: ");
				int inputID = Integer.parseInt(br.readLine());
				
				//aktivAccount = BankOfATM.findAccount(inputID);
				aktivAccount = findAccountWithFor(inputID);
				// checking if the ID is valid
				if(aktivAccount != null) {
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					
					cashout(amount);
					
				}else{
					System.out.println("This account dosen't exist. Please try again.");
				}
				
				System.out.println();
			} catch (Exception e) {
				break;
			}
		}
	}
	/*
	 *  das mit for verstehe ich noch nicht ganz
	 * 
	 */
	public BankAccount findAccountWithFor(int inputID) {
		for(BankAccount account : BankOfATM) {
			if(account.getAccountID()== inputID) {
				return account;
			}
		}
		return null;
	}
	
	
	/// geld wird ausgegeben
	public void cashout(int amount) {
		
		if(amount >= moneyInATM ) {
			System.out.println("There is not enough money in the ATM ");
			return;
		}
		if(amount > aktivAccount.getAccountBalance()) {
			
			System.out.println("Sorry, not enough money in your account.");
			
		}else {
			
			aktivAccount.setAccountBalance(aktivAccount.getAccountBalance()- amount);
			moneyInATM -= amount;
			System.out.println("Ok, here is your money, enjoy!");
			System.out.println("Current money in your account: " + aktivAccount.getAccountBalance());
		}
		
	};
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		
		Bank bank1 = new Bank("BigMoneyBank");
		
		ATM atm = new ATM(bank1,534);
		atm.run();
	};
};