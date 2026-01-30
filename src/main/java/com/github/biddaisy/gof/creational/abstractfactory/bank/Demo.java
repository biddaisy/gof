package com.github.biddaisy.gof.creational.abstractfactory.bank;

import com.github.biddaisy.gof.Logger;

public class Demo {

    public static void main(String[] args) {

        Logger.log("=== US Banking Products ===");
        BankingApplication usApp =
                new BankingApplication(new USBankingProductFactory());
        usApp.onboardCustomer();

        Logger.log("\n=== EU Banking Products ===");
        BankingApplication euApp =
                new BankingApplication(new EUBankingProductFactory());
        euApp.onboardCustomer();
    }
}
