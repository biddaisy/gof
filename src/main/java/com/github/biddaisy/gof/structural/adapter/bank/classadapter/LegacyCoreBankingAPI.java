package com.github.biddaisy.gof.structural.adapter.bank.classadapter;

import com.github.biddaisy.gof.Logger;

import java.math.BigDecimal;

/**
 * Legacy core parameterized API that cannot be modified.
 */
public class LegacyCoreBankingAPI {

    public BigDecimal fetchBalance(String acct) {
        return new BigDecimal("1000.00");
    }

    public void makeDeposit(String acct, BigDecimal amt) {
        Logger.log("[LEGACY] Deposited " + amt + " into " + acct);
    }

    public void makeWithdrawal(String acct, BigDecimal amt) {
        Logger.log("[LEGACY] Withdrew " + amt + " from " + acct);
    }
}
