package com.github.biddaisy.gof.creational.abstractfactory.bank;

public interface BankingProductFactory {

    Account createAccount();
    Loan createLoan();
    Card createCard();
}
