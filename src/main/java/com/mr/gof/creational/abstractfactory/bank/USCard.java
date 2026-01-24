package com.mr.gof.creational.abstractfactory.bank;

import com.mr.gof.Logger;

public class USCard implements Card {
    @Override
    public void issue() {
        Logger.log("Issuing US Credit Card (Visa/MC)");
    }
}
