package idh.java;

import java.util.Iterator;


public class AccountIterator implements Iterator<Account> {

    Bank bank;
    int account_number;

    public AccountIterator(Bank bank) {
        this.bank = bank;
    }

    @Override
    public boolean hasNext() {
        return 0 < bank.num_accounts();
    }

    @Override
    public Account next() {
        Account account = bank.get_account(account_number);
        account_number += 1;

        return account;
    }
}
