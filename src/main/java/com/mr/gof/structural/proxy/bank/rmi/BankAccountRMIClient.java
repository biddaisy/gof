package com.mr.gof.structural.proxy.bank.rmi;

import com.mr.gof.Logger;

import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Client that looks up the remote service and uses the Proxy.
 */
public class BankAccountRMIClient {

    private BankAccountRMIClient() {
    }

    static void main() throws RemoteException, NotBoundException {

        Logger.log("Connecting to RMI server...");

        Registry registry = LocateRegistry.getRegistry("localhost", 1099);

        BankAccountRemote remote =
                (BankAccountRemote) registry.lookup("BankAccountService");

        // Wrap remote object in a Proxy
        BankAccountRemote proxy = new BankAccountRemoteProxy(remote);

        Logger.log("=== Remote Proxy Demo (Java RMI Style) ===");

        proxy.deposit("ACC-1001", new BigDecimal("500"));
        proxy.withdraw("ACC-1001", new BigDecimal("200"));

        BigDecimal balance = proxy.getBalance("ACC-1001");
        Logger.log("Final balance: {0}", balance);
    }
}
