package com.mr.gof.behavioral.state;

public class ApprovalState implements PaymentState {
  private int amount;

  public ApprovalState(int amount) {
    this.amount = amount;
  }

  @Override public PaymentState doAction() {
    System.out.println("approval done");
    return new ProcessingState(amount);
  }
}
