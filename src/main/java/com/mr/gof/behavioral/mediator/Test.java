package com.mr.gof.behavioral.mediator;

public class Test {

  public static void main(String[] args) {
    InstrumentResolver instrumentResolver = new InstrumentResolver();
    Account account = Accounts.INSTANCE.getAccountList().get(1);
    instrumentResolver.getModelComposer().getOrderingAccountModel().setSelectedAccount(account);
    Account selectedAccount = instrumentResolver.getModelComposer().getOrderingAccountModel().getSelectedAccount();
    System.out.println("selectedAccount : " + selectedAccount);
  }
}
