package com.github.biddaisy.gof.structural.proxy.bank.remote;

import java.math.BigDecimal;

/**
 * Subject interface for remote bank account operations.
 */
public interface RemoteBankAccountService {
    BigDecimal getBalance(String accountId);
}
