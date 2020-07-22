package com.mr.gof.behavioral.mediator;

public class Test {

  public static void main(String[] args) {
    InstrumentResolver instrumentResolver = new InstrumentResolver();
    Account account = instrumentResolver.getModelComposer().getAccountModel().getSelectedAccount();
    System.out.println("account : " + account);
  }
}
