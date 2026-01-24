package com.mr.gof.creational.abstractfactory.bank;

import com.mr.gof.Logger;

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
