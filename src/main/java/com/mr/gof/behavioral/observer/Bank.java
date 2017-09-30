package com.mr.gof.behavioral.observer;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Account> accounts = new HashMap<String, Account>();
    private Government government = new Government();
    private static int accountNumberCounter;

    public String addAccount(String accountOwnerName){
        AccountOwner accountOwner = new AccountOwner(accountOwnerName);
        Account account = new Account(accountOwner, "account" + accountNumberCounter++);
        account.register(government);
        accounts.put(account.getAccountNumber(), account);
        return account.getAccountNumber();
    }

    public void depositAmount(String accountNumber, int amount){
        Account account = accounts.get(accountNumber);
        account.deposit(amount);
    }

    private void withdrawAmount(String accountNumber, int amount){
        Account account = accounts.get(accountNumber);
        account.withdraw(amount);
    }

    public static void main(String[] args){
        Bank bank = new Bank();
        String smithsAccountNumber = bank.addAccount("John Smith");
        String smirnovsAccountNumber = bank.addAccount("Ivan Smirnov");

        bank.depositAmount(smithsAccountNumber, 100);
        bank.depositAmount(smirnovsAccountNumber, 1000);

        bank.withdrawAmount(smithsAccountNumber, 99);
        bank.withdrawAmount(smirnovsAccountNumber, 999);

    }
}
