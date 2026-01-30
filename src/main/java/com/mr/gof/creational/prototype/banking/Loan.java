package com.mr.gof.creational.prototype.banking;

import static com.mr.gof.Logger.log;

/**
 * Concrete Prototype: Loan.
 */
public class Loan extends BankingProduct {

    private final String loanType;
    private final double rate;

    public Loan(String loanType, double rate) {
        this.loanType = loanType;
        this.rate = rate;
    }

    @Override
    public void display() {
        log("Loan [" + loanType + "], rate=" + rate);
    }
}
