package com.mr.gof.creational.factorymethod.generic;

import com.mr.gof.Logger;

/**
 * Concrete Product: MyProduct.
 */
public class MyProduct implements Product {

    public MyProduct() {
        Logger.log("MyProduct constructor invoked");
    }

    @Override
    public void execute() {
        Logger.log("Executing MyProduct...");
    }
}
