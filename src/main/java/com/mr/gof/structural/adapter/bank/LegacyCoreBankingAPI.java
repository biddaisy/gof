package com.mr.gof.structural.adapter.bank;

import com.mr.gof.Logger;

import java.math.BigDecimal;

/**
 * Adaptee: Legacy core parameterized API.
 *
 * This represents an old system that cannot be modified.
 * Its method names and semantics do not match the modern interface.
 *
 * The Adapter will translate between this API and BankAccountService.
 */
public class LegacyCoreBankingAPI {

    /**
     * Legacy method for retrieving account balance.
     */
    public BigDecimal fetchBalance(String acct) {
        return new BigDecimal("1000.00"); // Simulated legacy response
    }

    /**
     * Legacy method for depositing funds.
     */
    public void makeDeposit(String acct, BigDecimal amt) {
        Logger.log("[LEGACY] Deposited " + amt + " into " + acct);
    }

    /**
     * Legacy method for withdrawing funds.
     */
    public void makeWithdrawal(String acct, BigDecimal amt) {
        Logger.log("[LEGACY] Withdrew " + amt + " from " + acct);
    }
}
