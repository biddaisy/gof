package com.mr.gof.creational.abstractfactory.bank;

public class USBankingProductFactory implements BankingProductFactory {

    @Override
    public Account createAccount() {
        return new USAccount();
    }

    @Override
    public Loan createLoan() {
        return new USLoan();
    }

    @Override
    public Card createCard() {
        return new USCard();
    }
}
