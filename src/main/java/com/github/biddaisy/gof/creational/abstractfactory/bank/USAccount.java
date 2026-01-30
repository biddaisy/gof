package com.github.biddaisy.gof.creational.abstractfactory.bank;

import com.github.biddaisy.gof.Logger;

public class USAccount implements Account {
    @Override
    public void open() {
        Logger.log("Opening US Checking Account (FDIC insured)");
    }
}
