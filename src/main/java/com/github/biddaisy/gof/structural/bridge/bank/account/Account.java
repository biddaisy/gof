package com.github.biddaisy.gof.structural.bridge.bank.account;

import com.github.biddaisy.gof.structural.bridge.bank.Currency;
import com.github.biddaisy.gof.structural.bridge.bank.Person;
import com.github.biddaisy.gof.structural.bridge.bank.card.Card;

import java.math.BigDecimal;
import java.util.List;

public interface Account {

  String getNumber();

  Person getOwner();

  Currency getBaseCurrency();

  BigDecimal getCurrentBalance();

  void transfer(BigDecimal amount);

  List<Card> getCards();
}
