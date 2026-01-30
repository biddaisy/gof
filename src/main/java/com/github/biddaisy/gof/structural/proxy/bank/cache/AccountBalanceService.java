package com.github.biddaisy.gof.structural.proxy.bank.cache;

import java.math.BigDecimal;

public interface AccountBalanceService {
    BigDecimal getBalance(String accountId);
}
