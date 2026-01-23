package com.mr.gof.structural.proxy.bank.grpc;

import com.mr.gof.Logger;

import java.math.BigDecimal;

/**
 * Demonstrates a gRPC-style Remote Proxy.
 */
public class GrpcProxyBankDemo {

    private GrpcProxyBankDemo() {

    }

    static void main() {

        BankAccountGrpcService server = new BankAccountGrpcService();
        BankAccountGrpcStub stub = new BankAccountGrpcStub(server);

        BankAccountGrpcProxy proxy = new BankAccountGrpcProxy(stub);

        Logger.log("=== gRPC Remote Proxy Demo ===");

        proxy.deposit("ACC-1001", new BigDecimal("500"));
        proxy.withdraw("ACC-1001", new BigDecimal("200"));

        BigDecimal balance = proxy.getBalance("ACC-1001");
        Logger.log("Final balance: {0}", balance);
    }
}

