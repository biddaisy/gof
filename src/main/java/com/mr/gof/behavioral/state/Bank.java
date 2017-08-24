package com.mr.gof.behavioral.state;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Payment> payments = new ArrayList<Payment>();

    public int createPayment(int amount){
        payments.add(new Payment(amount));
        return payments.size() - 1;
    }

    public void auditPayment(int paymentId) throws PaymentException {
        Payment payment = payments.get(paymentId);
        if (!(payment.getPaymentState() instanceof AuditState)) {
             throw new PaymentException("payment " + paymentId + " not in awaiting audit status");
        }
        payment.doAction();
    }

    public void authorizePayment(int paymentId) throws PaymentException {
        Payment payment = payments.get(paymentId);
        if (!(payment.getPaymentState() instanceof AuthorizationState)) {
            throw new PaymentException("payment " + paymentId + " not in awaiting authorization status");
        }
        payment.doAction();
    }

    public void approvePayment(int paymentId) throws PaymentException {
        Payment payment = payments.get(paymentId);
        if (!(payment.getPaymentState() instanceof ApprovalState)) {
            throw new PaymentException("payment " + paymentId + " not in awaiting approval status");
        }
        payment.doAction();
    }

    public void doPayment(int paymentId)  throws PaymentException {
        Payment payment = payments.get(paymentId);
        if (!(payment.getPaymentState() instanceof ProcessingState)) {
            throw new PaymentException("payment " + paymentId + " not in awaiting payment status");
        }
        payment.doAction();
    }

    public static void main(String[] args){
        Bank bank = new Bank();
        int paymentId = bank.createPayment(13);
        try {
            bank.auditPayment(paymentId);
            bank.authorizePayment(paymentId);
            bank.approvePayment(paymentId);
            bank.doPayment(paymentId);
        } catch (PaymentException e) {
            e.printStackTrace();
        }
    }
}
