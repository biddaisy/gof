package com.mr.gof.behavioral.state;

public class Payment {

    private PaymentState paymentState;

    public PaymentState getPaymentState() {
        return paymentState;
    }

    public Payment(int amount){
        paymentState = new AuditState(amount);
    }

    public void doAction(){
        paymentState =  paymentState.doAction();
    }

}
