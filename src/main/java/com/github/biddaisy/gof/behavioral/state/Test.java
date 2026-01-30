package com.github.biddaisy.gof.behavioral.state;

public class Test {

  public static void main(String[] args) {
    Bank bank = new Bank();
    int paymentId = bank.createPayment(13);
    try {
      bank.auditPayment(paymentId);
      bank.authorizePayment(paymentId);
      bank.approvePayment(paymentId);
      bank.doPayment(paymentId);
    }
    catch (PaymentException e) {
      e.printStackTrace();
    }
  }

}
