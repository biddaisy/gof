package com.github.biddaisy.gof.structural.proxy.bank.remote;

import com.github.biddaisy.gof.Logger;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Simulated remote service running on another server.
 * Pretends to process requests with network latency.
 */
public class RealRemoteBankAccountService implements RemoteBankAccountService {

    private final Map<String, BigDecimal> balances = new ConcurrentHashMap<>();

    public RealRemoteBankAccountService() {
        balances.put("ACC-1001", new BigDecimal("1500.00"));
        balances.put("ACC-2002", new BigDecimal("250.50"));
    }

    @Override
    public BigDecimal getBalance(String accountId) {
        simulateNetworkLatency();
        Logger.log("[REMOTE SERVER] Fetching balance for {0}", accountId);
        return balances.getOrDefault(accountId, BigDecimal.ZERO);
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(300); // 300ms latency
        } catch (InterruptedException ignored) {
        }
    }
}
