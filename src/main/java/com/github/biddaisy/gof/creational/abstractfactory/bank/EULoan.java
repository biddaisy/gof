package com.github.biddaisy.gof.creational.abstractfactory.bank;

import com.github.biddaisy.gof.Logger;

public class EULoan implements Loan {
    @Override
    public void approve() {
        Logger.log("Approving EU Loan (ECB regulations)");
    }
}
