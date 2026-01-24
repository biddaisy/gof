package com.mr.gof.behavioral.state;

import com.mr.gof.Logger;

public class AuditState implements PaymentState {
  private int amount;

  public AuditState(int amount) {
    this.amount = amount;
  }

  @Override
  public PaymentState doAction() {
    Logger.log("audit done");
    return new AuthorizationState(amount);
  }
}
