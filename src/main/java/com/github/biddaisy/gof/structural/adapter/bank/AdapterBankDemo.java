package com.github.biddaisy.gof.structural.adapter.bank;

import com.github.biddaisy.gof.Logger;

import java.math.BigDecimal;

/**
 * Client code that depends ONLY on the modern interface.
 * <p>
 * Thanks to the Adapter, this code works with the legacy system
 * without knowing anything about it.
 */
public class AdapterBankDemo {

    private AdapterBankDemo() {

    }

    static void main() {

        // Legacy system instance (cannot be changed)
        LegacyCoreBankingAPI legacy = new LegacyCoreBankingAPI();

        // Adapter wraps the legacy API and exposes the modern interface
        BankAccountService service = new LegacyBankAdapter(legacy);

        // Client uses the modern interface — completely unaware of legacy details
        Logger.log("Balance: " + service.getBalance("ACC-1001"));
        service.deposit("ACC-1001", new BigDecimal("250.00"));
        service.withdraw("ACC-1001", new BigDecimal("100.00"));
    }
}
