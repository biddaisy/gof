package com.mr.gof.structural.adapter.bank.classadapter;

import java.math.BigDecimal;

/**
 * Target interface expected by modern parameterized services.
 */
public interface BankAccountService {
    BigDecimal getBalance(String accountId);
    void deposit(String accountId, BigDecimal amount);
    void withdraw(String accountId, BigDecimal amount);
}
