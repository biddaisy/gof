package com.mr.gof.creational.abstractfactory.bank;

public interface BankingProductFactory {

    Account createAccount();
    Loan createLoan();
    Card createCard();
}
