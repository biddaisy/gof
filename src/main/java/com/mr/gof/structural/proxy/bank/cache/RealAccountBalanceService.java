package com.mr.gof.structural.proxy.bank.cache;

import com.mr.gof.Logger;

import java.math.BigDecimal;
import java.util.Random;

public class RealAccountBalanceService implements AccountBalanceService {

    private final Random random = new Random();

    @Override
    public BigDecimal getBalance(String accountId) {
        Logger.log("[REAL] Fetching balance from remote system...");

        simulateSlowRemoteCall();

        return new BigDecimal("1000.00")
                .add(BigDecimal.valueOf(random.nextInt(100)));
    }

    private void simulateSlowRemoteCall() {
        try {
            Thread.sleep(1500); // 1.5 seconds
        } catch (InterruptedException ignored) {
        }
    }
}
