package com.mr.gof.creational.abstractfactory.bank;

public class EUBankingProductFactory implements BankingProductFactory {

    @Override
    public Account createAccount() {
        return new EUAccount();
    }

    @Override
    public Loan createLoan() {
        return new EULoan();
    }

    @Override
    public Card createCard() {
        return new EUCard();
    }
}
