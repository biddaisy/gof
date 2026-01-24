package com.mr.gof.creational.abstractfactory.bank;

import com.mr.gof.Logger;

public class EULoan implements Loan {
    @Override
    public void approve() {
        Logger.log("Approving EU Loan (ECB regulations)");
    }
}
