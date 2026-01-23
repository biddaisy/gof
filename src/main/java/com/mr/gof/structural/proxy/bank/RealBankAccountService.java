package com.mr.gof.structural.proxy.bank;

import com.mr.gof.Logger;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Real implementation of the bank account service.
 * Stores balances and performs actual operations.
 */
public class RealBankAccountService implements BankAccountService {

    private final Map<String, BigDecimal> balances = new ConcurrentHashMap<>();

    @Override
    public void deposit(String accountId, BigDecimal amount) {
        balances.merge(accountId, amount, BigDecimal::add);
        Logger.log("Deposited {0} to account {1}", amount, accountId);
    }

    @Override
    public void withdraw(String accountId, BigDecimal amount) {
        balances.merge(accountId, amount.negate(), BigDecimal::add);
        Logger.log("Withdrew {0} from account {1}", amount, accountId);
    }

    @Override
    public BigDecimal getBalance(String accountId) {
        return balances.getOrDefault(accountId, BigDecimal.ZERO);
    }
}
