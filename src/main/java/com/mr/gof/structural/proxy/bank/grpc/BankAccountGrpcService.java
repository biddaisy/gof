package com.mr.gof.structural.proxy.bank.grpc;

import com.mr.gof.Logger;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Simulated gRPC server-side implementation.
 */
public class BankAccountGrpcService {

    private final Map<String, BigDecimal> balances = new ConcurrentHashMap<>();

    public BankAccountGrpcService() {
        balances.put("ACC-1001", new BigDecimal("1000.00"));
        balances.put("ACC-2002", new BigDecimal("250.50"));
    }

    public BalanceResponse getBalance(BalanceRequest request) {
        simulateLatency();
        Logger.log("[gRPC SERVER] getBalance({0})", request.accountId());
        return new BalanceResponse(balances.getOrDefault(request.accountId(), BigDecimal.ZERO));
    }

    public TransactionResponse deposit(TransactionRequest request) {
        simulateLatency();
        Logger.log("[gRPC SERVER] deposit({0}, {1})", request.accountId(), request.amount());
        balances.merge(request.accountId(), request.amount(), BigDecimal::add);
        return new TransactionResponse(true);
    }

    public TransactionResponse withdraw(TransactionRequest request) {
        simulateLatency();
        Logger.log("[gRPC SERVER] withdraw({0}, {1})", request.accountId(), request.amount());
        balances.merge(request.accountId(), request.amount().negate(), BigDecimal::add);
        return new TransactionResponse(true);
    }

    private void simulateLatency() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ignored) {
        }
    }
}
