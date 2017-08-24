package com.mr.gof.behavioral.state;

public class AuthorizationState implements PaymentState
{
    private int amount;

    public AuthorizationState(int amount) {
        this.amount = amount;
    }

    @Override
    public PaymentState doAction() {
        System.out.println("authorization done");
        return new ApprovalState(amount);
    }
}
