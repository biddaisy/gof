package com.github.biddaisy.gof.structural.proxy.bank.remote;

import com.github.biddaisy.gof.Logger;

/**
 * Demonstrates a Remote Proxy simulating network calls.
 */
public class RemoteProxyBankDemo {

    private RemoteProxyBankDemo() {
    }

    static void main() {

        RemoteBankAccountService remoteService = new RealRemoteBankAccountService();

        RemoteBankAccountService proxy =
                new RemoteBankAccountProxy(remoteService);

        Logger.log("=== Remote Proxy Demo ===");

        proxy.getBalance("ACC-1001");
        proxy.getBalance("ACC-2002");
        proxy.getBalance("ACC-9999"); // non-existing
    }
}
