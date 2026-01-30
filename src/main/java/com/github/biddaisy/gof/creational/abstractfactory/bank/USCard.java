package com.github.biddaisy.gof.creational.abstractfactory.bank;

import com.github.biddaisy.gof.Logger;

public class USCard implements Card {
    @Override
    public void issue() {
        Logger.log("Issuing US Credit Card (Visa/MC)");
    }
}
