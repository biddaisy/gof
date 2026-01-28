package com.mr.gof.structural.adapter.bank.bidirectional;

import java.math.BigDecimal;

/**
 * Modern parameterized interface used by new services.
 */
public interface BankAccountService {
    BigDecimal getBalance(String accountId);
    void deposit(String accountId, BigDecimal amount);
    void withdraw(String accountId, BigDecimal amount);
}
