package com.github.biddaisy.gof.structural.proxy.bank.cache;

import com.github.biddaisy.gof.Logger;

public class CacheProxyBankDemo {

    private CacheProxyBankDemo() {
    }

    static void main() {

        AccountBalanceService real = new RealAccountBalanceService();
        AccountBalanceService proxy = new AccountBalanceCacheProxy(real);

        Logger.log("=== Cache Proxy Demo ===");

        proxy.getBalance("ACC-1001"); // slow, remote call
        proxy.getBalance("ACC-1001"); // fast, cached
        proxy.getBalance("ACC-1001"); // fast, cached

        proxy.getBalance("ACC-2002"); // slow, remote call
        proxy.getBalance("ACC-2002"); // fast, cached
    }
}
