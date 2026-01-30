package com.github.biddaisy.gof.creational.abstractfactory.bank;

import com.github.biddaisy.gof.Logger;

public class EUAccount implements Account {
    @Override
    public void open() {
        Logger.log("Opening EU Current Account (SEPA compliant)");
    }
}
