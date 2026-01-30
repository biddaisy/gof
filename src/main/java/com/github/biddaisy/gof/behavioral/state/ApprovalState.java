package com.github.biddaisy.gof.behavioral.state;

import com.github.biddaisy.gof.Logger;

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
