package com.mr.gof.creational.abstractfactory.bank;

import com.mr.gof.Logger;

public class EUAccount implements Account {
    @Override
    public void open() {
        Logger.log("Opening EU Current Account (SEPA compliant)");
    }
}
