package com.mr.gof.creational.abstractfactory.bank;

import com.mr.gof.Logger;

public class EUCard implements Card {
    @Override
    public void issue() {
        Logger.log("Issuing EU Debit Card (Maestro)");
    }
}
