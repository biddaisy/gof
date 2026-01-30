package com.github.biddaisy.gof.structural.proxy.bank.grpc;

import java.math.BigDecimal;

public record BalanceResponse(BigDecimal balance) {
}