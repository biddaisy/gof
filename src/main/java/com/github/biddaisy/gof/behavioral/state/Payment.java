package com.mr.gof.behavioral.state;

public class Payment {

  private PaymentState paymentState;

  public Payment(int amount) {
    paymentState = new AuditState(amount);
  }

  public PaymentState getPaymentState() {
    return paymentState;
  }

  public void doAction() {
    paymentState = paymentState.doAction();
  }

}
