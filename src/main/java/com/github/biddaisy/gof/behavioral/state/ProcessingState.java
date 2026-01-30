package com.mr.gof.behavioral.state;

import com.github.biddaisy.gof.Logger;

public class ProcessingState implements PaymentState {
  private int amount;

  public ProcessingState(int amount) {
    this.amount = amount;
  }

  @Override
  public PaymentState doAction() {
    Logger.log("payment done");
    return this;
  }

}
