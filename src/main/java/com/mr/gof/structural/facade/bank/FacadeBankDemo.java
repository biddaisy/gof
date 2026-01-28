package com.mr.gof.structural.facade.bank;

import java.math.BigDecimal;

/**
 * Demonstrates a realistic parameterized workflow using the Facade pattern.
 */
public class FacadeBankDemo {

    public static final String CUST_1001 = "CUST-1001";

    private FacadeBankDemo() {
    }

    static void main() {

        BankFacade bank = new BankFacade();

        bank.onboardCustomer(CUST_1001);
        bank.transferMoney(CUST_1001, "ACC-1", "ACC-2", BigDecimal.valueOf(500));
        bank.applyForLoan(CUST_1001, 20_000);
    }
}
