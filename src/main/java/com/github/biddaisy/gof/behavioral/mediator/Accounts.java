package com.mr.gof.behavioral.mediator;

import static com.mr.gof.behavioral.mediator.Bank.*;
import static com.mr.gof.behavioral.mediator.Currency.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Accounts {

  public static final Accounts INSTANCE = new Accounts();

  private Accounts() {
  }

  private List<Account> accountList;

  {
    accountList = new ArrayList<>();

    accountList.add(new Account("1", USD, FIRST_NATIONAL_BANK));
    accountList.add(new Account("2", ZAR, FIRST_NATIONAL_BANK));
    accountList.add(new Account("3", BYN, FIRST_NATIONAL_BANK));
    accountList.add(new Account("4", EUR, FIRST_NATIONAL_BANK));

    accountList.add(new Account("5", USD, NON_STANDARD_BANK));
    accountList.add(new Account("6", ZAR, NON_STANDARD_BANK));
    accountList.add(new Account("7", BYN, NON_STANDARD_BANK));
    accountList.add(new Account("8", EUR, NON_STANDARD_BANK));

    accountList.add(new Account("9", USD, CROCODILE_BANK));
    accountList.add(new Account("10", ZAR, CROCODILE_BANK));
    accountList.add(new Account("11", BYN, CROCODILE_BANK));
    accountList.add(new Account("12", EUR, CROCODILE_BANK));

    accountList = Collections.unmodifiableList(accountList);
  }

  public List<Account> getAccountList() {
    return accountList;
  }
}
