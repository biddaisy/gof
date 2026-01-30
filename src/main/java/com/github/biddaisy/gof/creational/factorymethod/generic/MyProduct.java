package com.github.biddaisy.gof.creational.factorymethod.generic;

import com.github.biddaisy.gof.Logger;

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
