package com.github.biddaisy.gof.creational.abstractfactory.bank;

import com.github.biddaisy.gof.Logger;

public class USLoan implements Loan {
    @Override
    public void approve() {
        Logger.log("Approving US Personal Loan (FICO-based underwriting)");
    }
}
