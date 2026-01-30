package com.github.biddaisy.gof.behavioral.observer;

import com.github.biddaisy.gof.Logger;

public class Government implements Observer {

  @Override
  public void update(Subject subject) {
    if (subject instanceof Account) {
      Account account = (Account) subject;
      AccountOwner accountOwner = account.getAccountOwner();
      Logger.log("Government: " + accountOwner.getName() + " got balance " + account.getAmount());
    }
  }

}
