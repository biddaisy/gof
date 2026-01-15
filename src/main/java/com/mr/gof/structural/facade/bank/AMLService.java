package com.mr.gof.structural.facade.bank;

import com.mr.gof.Logger;

import java.math.BigDecimal;

/**
 * Performs Anti-Money Laundering (AML) checks.
 * Flags suspicious customers or transactions.
 */
public class AMLService {

    public boolean isCustomerClean(String customerId) {
        Logger.debug("Running AML screening for customer {0}", customerId);
        return true; // assume customer is clean
    }

    public boolean isTransactionAllowed(BigDecimal amount) {
        Logger.debug("Checking AML rules for transaction amount {0}", amount);
        return amount.compareTo(BigDecimal.valueOf(50_000)) < 0 ; // simple AML rule
    }
}
