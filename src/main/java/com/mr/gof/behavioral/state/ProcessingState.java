package com.mr.gof.behavioral.state;

public class ProcessingState implements PaymentState
{
    private int amount;

    public ProcessingState(int amount) {
        this.amount = amount;
    }

    @Override
    public PaymentState doAction() {
        System.out.println("payment done");
        return this;
    }

}
