package com.github.biddaisy.gof.behavioral.mediator.model;

import java.util.ArrayList;
import java.util.List;

import com.github.biddaisy.gof.behavioral.mediator.Account;
import com.github.biddaisy.gof.behavioral.mediator.Accounts;

public class OrderingAccountModel extends BaseModel {

  private Account selectedAccount;

  private final List<Account> accounts = Accounts.INSTANCE.getAccountList();

  public OrderingAccountModel() {
    setDisabled(false);
  }

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
