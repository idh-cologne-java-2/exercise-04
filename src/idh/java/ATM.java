package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class ATM implements Iterable<Account> {
	Bank newBank ; 
	
	@Override
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return new AccountIterator(this);
	};

	
	private int ATMBalance = 2000; 
	
	
	public Account getAcc( int count) {
		return newBank.getCurrentbank()[count];
	}
	
	public int getSize() {
		return newBank.getCurrentbank().length;
	}
	
	public ATM() {
		newBank = new Bank();	
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
				System.out.print(" Please Enter your Account ID:  "); 
				int currentID = Integer.parseInt(br.readLine());
					 Account currentacc = newBank.getCurrentbank()[0] ; 
				Iterator<Account> iter = iterator();
				 while(iter.hasNext()) {
					 currentacc = iter.next();
					 if(currentID == currentacc.id) {
						break;
						} 
					 if(!iter.hasNext()) {
							System.err.println("Wrong ID please Try again ..\n ");
							run(); 
					 } 
				 }
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount , currentID,currentacc);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount , int currentID, Account s) {
		
		if( amount > ATMBalance) {
			System.err.print("Sorry there is not enough money in the ATM"); 
		} else {
			if( amount > s.balance) {
				System.err.println("Sorry you dont have enough money");
			}else {
				s.withdraw(amount);
				System.out.print("You cashed out:  " + amount); 			
			}
			}
		

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
		
	}

	

}