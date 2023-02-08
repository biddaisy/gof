package com.mr.gof.structural.bridge.bank.card;

import com.mr.gof.structural.bridge.bank.account.Account;
import com.mr.gof.structural.bridge.bank.Currency;
import com.mr.gof.structural.bridge.bank.Person;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DebitCard extends BasicCard {

    public DebitCard(String number, Person owner, PaymentSystem paymentSystem, LocalDate validThru, Currency cardCurrency, Account account) {
        super(number, owner, paymentSystem, validThru, cardCurrency, account);
    }

    @Override
    public void withdraw(BigDecimal amount, Currency currency) {
        var exchangedAmount = exchange(amount, currency);
        var currentBalance = account.getCurrentBalance();
        var updatedBalance = currentBalance.subtract(exchangedAmount);
        if (updatedBalance.signum() == -1){
            throw new IllegalArgumentException("Not enough balance");
        }
        super.withdraw(exchangedAmount, account.getBaseCurrency());
    }
}
