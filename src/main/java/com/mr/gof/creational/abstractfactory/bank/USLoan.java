package com.mr.gof.creational.abstractfactory.bank;

import com.mr.gof.Logger;

public class USLoan implements Loan {
    @Override
    public void approve() {
        Logger.log("Approving US Personal Loan (FICO-based underwriting)");
    }
}
