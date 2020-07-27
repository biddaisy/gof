package com.mr.gof.behavioral.state;

public class AuditState implements PaymentState {
  private int amount;

  public AuditState(int amount) {
    this.amount = amount;
  }

  @Override
  public PaymentState doAction() {
    System.out.println("audit done");
    return new AuthorizationState(amount);
  }
}
