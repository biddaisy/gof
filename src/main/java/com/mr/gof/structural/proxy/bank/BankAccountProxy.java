package com.mr.gof.structural.proxy.bank;

import com.mr.gof.Logger;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Proxy that controls access to the real bank account service.
 * Performs:
 * - Authentication
 * - Account blocking checks
 * - Logging
 */
public class BankAccountProxy implements BankAccountService {

    private final BankAccountService realService;
    private final Set<String> blockedAccounts;
    private final String authenticatedCustomerId;

    public BankAccountProxy(BankAccountService realService,
                            String authenticatedCustomerId,
                            Set<String> blockedAccounts) {

        this.realService = realService;
        this.authenticatedCustomerId = authenticatedCustomerId;
        this.blockedAccounts = blockedAccounts;
    }

    private boolean isAccessAllowed(String accountId) {
        if (!authenticatedCustomerId.equals(accountId)) {
            Logger.warn("ACCESS DENIED: Customer {0} attempted to access account {1}",
                    authenticatedCustomerId, accountId);
            return false;
        }

        if (blockedAccounts.contains(accountId)) {
            Logger.warn("ACCESS DENIED: Account {0} is blocked", accountId);
            return false;
        }

        return true;
    }

    @Override
    public void deposit(String accountId, BigDecimal amount) {
        if (!isAccessAllowed(accountId)) return;
        Logger.log("Proxy: deposit request validated");
        realService.deposit(accountId, amount);
    }

    @Override
    public void withdraw(String accountId, BigDecimal amount) {
        if (!isAccessAllowed(accountId)) return;
        Logger.log("Proxy: withdraw request validated");
        realService.withdraw(accountId, amount);
    }

    @Override
    public BigDecimal getBalance(String accountId) {
        if (!isAccessAllowed(accountId)) return BigDecimal.ZERO;
        Logger.log("Proxy: balance request validated");
        return realService.getBalance(accountId);
    }
}
