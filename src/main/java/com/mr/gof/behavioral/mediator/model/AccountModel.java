package com.mr.gof.behavioral.mediator.model;

import com.mr.gof.behavioral.mediator.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountModel {
  private Account selectedAccount;

  private final List<Account> accounts = new ArrayList<Account>();

  public Account getSelectedAccount() {
    return selectedAccount;
  }

  public void setSelectedAccount(Account selectedAccount) {
    this.selectedAccount = selectedAccount;
  }

  public List<Account> getAccounts() {
    return new ArrayList<>(accounts);
  }
}
