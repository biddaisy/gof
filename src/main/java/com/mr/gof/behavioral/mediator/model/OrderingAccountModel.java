package com.mr.gof.behavioral.mediator.model;

import java.util.ArrayList;
import java.util.List;

import com.mr.gof.behavioral.mediator.Account;

public class OrderingAccountModel extends BaseModel {

  private Account selectedAccount;

  private final List<Account> accounts = new ArrayList<Account>();

  public Account getSelectedAccount() {
    return selectedAccount;
  }

  public void setSelectedAccount(Account selectedAccount) {
    this.selectedAccount = selectedAccount;
    changed();
  }

  public List<Account> getAccounts() {
    return new ArrayList<>(accounts);
  }
}
