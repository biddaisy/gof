package com.mr.gof.structural.proxy.bank.grpc;

/**
 * Simulated gRPC client stub.
 * In real gRPC, this is auto-generated.
 */
public class BankAccountGrpcStub {

    private final BankAccountGrpcService remoteService;

    public BankAccountGrpcStub(BankAccountGrpcService remoteService) {
        this.remoteService = remoteService;
    }

    public BalanceResponse getBalance(BalanceRequest request) {
        return remoteService.getBalance(request);
    }

    public TransactionResponse deposit(TransactionRequest request) {
        return remoteService.deposit(request);
    }

    public TransactionResponse withdraw(TransactionRequest request) {
        return remoteService.withdraw(request);
    }
}
