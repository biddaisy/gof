package com.mr.gof.creational.abstractfactory.bank;

public class BankingApplication {

    private final BankingProductFactory factory;

    public BankingApplication(BankingProductFactory factory) {
        this.factory = factory;
    }

    public void onboardCustomer() {
        Account account = factory.createAccount();
        Loan loan = factory.createLoan();
        Card card = factory.createCard();

        account.open();
        loan.approve();
        card.issue();
    }
}
