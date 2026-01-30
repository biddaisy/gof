package com.github.biddaisy.gof.behavioral.observer;

public class Test {

  public static void main(String[] args) {
    Bank bank = new Bank();
    String smithsAccountNumber = bank.addAccount("John Smith");
    String smirnovsAccountNumber = bank.addAccount("Ivan Smirnov");

    bank.depositAmount(smithsAccountNumber, 100);
    bank.depositAmount(smirnovsAccountNumber, 1000);

    bank.withdrawAmount(smithsAccountNumber, 99);
    bank.withdrawAmount(smirnovsAccountNumber, 999);

  }

}
