package com.github.biddaisy.gof.creational.abstractfactory.bank;

import com.github.biddaisy.gof.Logger;

public class EUCard implements Card {
    @Override
    public void issue() {
        Logger.log("Issuing EU Debit Card (Maestro)");
    }
}
