package com.mr.gof.creational.abstractfactory.bank;

import com.mr.gof.Logger;

public class USAccount implements Account {
    @Override
    public void open() {
        Logger.log("Opening US Checking Account (FDIC insured)");
    }
}
