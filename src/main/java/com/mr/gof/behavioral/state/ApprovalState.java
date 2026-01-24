package com.mr.gof.behavioral.state;

import com.mr.gof.Logger;

public class ApprovalState implements PaymentState {
  private int amount;

  public ApprovalState(int amount) {
    this.amount = amount;
  }

  @Override
  public PaymentState doAction() {
    Logger.log("approval done");
    return new ProcessingState(amount);
  }
}
