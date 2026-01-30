package com.github.biddaisy.gof.structural.bridge.bank;

import com.github.biddaisy.gof.structural.bridge.bank.account.Account;

import java.util.ArrayList;
import java.util.List;

public class Bank {

  private final String name;

  private final List<Account> accounts = new ArrayList<>();

  private final List<Atm> atms = new ArrayList<>();

  public Bank(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public List<Account> getAccounts() {
    return List.copyOf(accounts);
  }

  public List<Atm> getAtms() {
    return List.copyOf(atms);
  }

  public void addAccount(Account account) {
    accounts.add(account);
  }

  public void addAtm(Atm atm) {
    atms.add(atm);
  }
}
