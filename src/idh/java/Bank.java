package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank {

    Account[] accounts = new Account[10];

    public Bank() {
        Random random = new Random();

        for (int i = 0; i < accounts.length; i++) {
            int account_balance = random.nextInt(10000);
            accounts[i] = new Account(i, account_balance);
            System.out.println("Sparkasse.INFO: Initializing account with number: '" + i + "' and " + account_balance + "€ balance");
        }
    }

    public Iterator<Account> iterator() {
        return  new AccountIterator(this);
    }

    public int num_accounts() {
        return accounts.length;
    }

    public Account get_account(int i) {
        return accounts[i];
    }
}
