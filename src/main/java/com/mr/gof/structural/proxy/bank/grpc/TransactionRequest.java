package com.mr.gof.structural.proxy.bank.grpc;

import java.math.BigDecimal;

public record TransactionRequest(String accountId, BigDecimal amount) {
}
