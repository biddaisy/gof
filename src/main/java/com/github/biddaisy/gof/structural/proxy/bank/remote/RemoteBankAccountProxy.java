package com.github.biddaisy.gof.structural.proxy.bank.remote;

import com.github.biddaisy.gof.Logger;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Remote Proxy that simulates:
 * - Network calls
 * - Latency
 * - Connection failures
 * - Retry logic
 *
 * The client interacts with this proxy instead of the real remote service.
 */
public class RemoteBankAccountProxy implements RemoteBankAccountService {

    private final RemoteBankAccountService remoteService;
    private final Random random = new Random();

    public RemoteBankAccountProxy(RemoteBankAccountService remoteService) {
        this.remoteService = remoteService;
    }

    @Override
    public BigDecimal getBalance(String accountId) {
        Logger.log("[PROXY] Requesting balance for {0}", accountId);

        int attempts = 0;
        while (attempts < 3) {
            attempts++;

            try {
                simulateNetworkCall();
                BigDecimal balance = remoteService.getBalance(accountId);
                Logger.log("[PROXY] Response received: {0}", balance);
                return balance;

            } catch (RuntimeException ex) {
                Logger.warn("[PROXY] Network error on attempt {0}: {1}", attempts, ex.getMessage());
            }
        }

        Logger.error("[PROXY] All retry attempts failed");
        return BigDecimal.ZERO;
    }

    private void simulateNetworkCall() {
        // 20% chance of network failure
        if (random.nextInt(10) < 2) {
            throw new RuntimeException("Simulated network failure");
        }

        // Simulate network latency
        try {
            Thread.sleep(150);
        } catch (InterruptedException ignored) {
        }
    }
}
