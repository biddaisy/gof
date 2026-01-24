package com.mr.gof.structural.adapter.bank.classadapter;

import com.mr.gof.Logger;

import java.math.BigDecimal;

/**
 * Client code that depends only on the modern interface.
 */
public class ClassAdapterBankDemo {

    private ClassAdapterBankDemo() {

    }

    static void main() {

        BankAccountService service = new LegacyBankClassAdapter();

        Logger.log("Balance: " + service.getBalance("ACC-1001"));
        service.deposit("ACC-1001", new BigDecimal("250.00"));
        service.withdraw("ACC-1001", new BigDecimal("100.00"));
    }
}
