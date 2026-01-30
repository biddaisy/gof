package com.github.biddaisy.gof.behavioral.state;

import com.github.biddaisy.gof.Logger;

public class AuthorizationState implements PaymentState {
  private int amount;

  public AuthorizationState(int amount) {
    this.amount = amount;
  }

  @Override
  public PaymentState doAction() {
    Logger.log("authorization done");
    return new ApprovalState(amount);
  }
}
