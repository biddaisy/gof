package com.mr.gof.structural.proxy.bank.cache;

import com.mr.gof.Logger;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Cache Proxy that stores results to avoid repeated remote calls.
 */
public class AccountBalanceCacheProxy implements AccountBalanceService {

    private final AccountBalanceService realService;

    // Thread-safe cache
    private final Map<String, BigDecimal> cache = new ConcurrentHashMap<>();

    public AccountBalanceCacheProxy(AccountBalanceService realService) {
        this.realService = realService;
    }

    @Override
    public BigDecimal getBalance(String accountId) {

        BigDecimal cached = cache.get(accountId);
        if (cached != null) {
            Logger.log("[CACHE] Returning cached balance for {0}", accountId);
            return cached;
        }

        Logger.log("[CACHE] Cache miss for {0}. Calling real service...", accountId);
        BigDecimal balance = realService.getBalance(accountId);

        cache.put(accountId, balance);

        return balance;
    }
}
