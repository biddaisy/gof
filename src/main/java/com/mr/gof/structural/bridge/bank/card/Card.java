package com.mr.gof.structural.bridge.bank.card;

import com.mr.gof.structural.bridge.bank.Currency;
import com.mr.gof.structural.bridge.bank.Person;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Card {

    String getNumber();

    PaymentSystem getPaymentSystem();

    Person getOwner();

    BigDecimal getAvailableBalance();

    void withdraw(BigDecimal amount, Currency currency);

    LocalDate getValidThru();

    CardStatus getCardStatus();

    Currency getCardCurrency();
}
