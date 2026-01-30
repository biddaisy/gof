package com.github.biddaisy.gof.structural.proxy.bank;

import com.github.biddaisy.gof.Logger;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Demonstrates the Proxy pattern in a parameterized context.
 */
public class ProxyBankDemo {

    private ProxyBankDemo() {
    }

    static void main() {

        BankAccountService realService = new RealBankAccountService();

        // Customer CUST-1001 is authenticated
        BankAccountService proxy =
                new BankAccountProxy(realService, "CUST-1001", Set.of("CUST-9999"));

        Logger.log("=== Valid operations ===");
        proxy.deposit("CUST-1001", new BigDecimal("500"));
        proxy.withdraw("CUST-1001", new BigDecimal("200"));
        Logger.log("Balance: {0}", proxy.getBalance("CUST-1001"));

        Logger.log("=== Unauthorized access attempt ===");
        proxy.getBalance("CUST-2002");

        Logger.log("=== Blocked account attempt ===");
        proxy.deposit("CUST-9999", new BigDecimal("100"));
    }
}
