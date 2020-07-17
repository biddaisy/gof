package com.mr.gof.behavioral.observer;

public class Government implements Observer {

    @Override
    public void update(Subject subject) {
        if (subject instanceof Account) {
            Account account = (Account) subject;
            AccountOwner accountOwner = account.getAccountOwner();
            System.out.println("Government: " + accountOwner.getName() + " got balance " + account.getAmount());
        }
    }

}
