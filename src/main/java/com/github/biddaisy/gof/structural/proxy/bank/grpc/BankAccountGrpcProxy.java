package com.github.biddaisy.gof.structural.proxy.bank.grpc;

import com.github.biddaisy.gof.Logger;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Remote Proxy that wraps the gRPC stub.
 * Adds:
 * - Logging
 * - Retry logic
 * - Network failure simulation
 */
public class BankAccountGrpcProxy {

    private final BankAccountGrpcStub stub;
    private final Random random = new Random();

    public BankAccountGrpcProxy(BankAccountGrpcStub stub) {
        this.stub = stub;
    }

    public BigDecimal getBalance(String accountId) {
        Logger.log("[PROXY] getBalance({0})", accountId);
        return retry(() -> stub.getBalance(new BalanceRequest(accountId)).balance());
    }

    public boolean deposit(String accountId, BigDecimal amount) {
        Logger.log("[PROXY] deposit({0}, {1})", accountId, amount);
        return Boolean.TRUE.equals(retry(() -> stub.deposit(new TransactionRequest(accountId, amount)).success()));
    }

    public boolean withdraw(String accountId, BigDecimal amount) {
        Logger.log("[PROXY] withdraw({0}, {1})", accountId, amount);
        return Boolean.TRUE.equals(retry(() -> stub.withdraw(new TransactionRequest(accountId, amount)).success()));
    }

    private <T> T retry(RemoteCall<T> call) {
        int attempts = 0;

        while (attempts < 3) {
            attempts++;

            try {
                simulateNetwork();
                return call.execute();
            } catch (RuntimeException ex) {
                Logger.warn("[PROXY] Network error attempt {0}: {1}", attempts, ex.getMessage());
            }
        }

        Logger.error("[PROXY] All retry attempts failed");
        return null;
    }

    private void simulateNetwork() {
        if (random.nextInt(10) < 2) {
            throw new RuntimeException("Simulated gRPC network failure");
        }
    }

    private interface RemoteCall<T> {
        T execute();
    }
}
