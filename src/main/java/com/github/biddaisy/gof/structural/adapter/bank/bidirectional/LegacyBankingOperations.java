package com.github.biddaisy.gof.structural.adapter.bank.bidirectional;

import java.math.BigDecimal;

/**
 * Legacy parameterized interface used by old systems.
 */
public interface LegacyBankingOperations {
    BigDecimal fetchBalance(String acct);
    void makeDeposit(String acct, BigDecimal amt);
    void makeWithdrawal(String acct, BigDecimal amt);
}
