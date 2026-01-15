package com.mr.gof.structural.facade.bank;

import com.mr.gof.Logger;

/**
 * Performs Anti-Money Laundering (AML) checks.
 * Flags suspicious customers or transactions.
 */
public class AMLService {

    public boolean isCustomerClean(String customerId) {
        Logger.debug("Running AML screening for customer {0}", customerId);
        return true; // assume customer is clean
    }

    public boolean isTransactionAllowed(double amount) {
        Logger.debug("Checking AML rules for transaction amount {0}", amount);
        return amount < 50_000; // simple AML rule
    }
}
