package com.github.biddaisy.gof.structural.proxy.bank.rmi;

import com.github.biddaisy.gof.Logger;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Starts the RMI server and binds the remote object.
 */
public class BankAccountRMIServer {

    private BankAccountRMIServer() {
    }

    static void main() throws RemoteException {

        Logger.log("Starting RMI server...");

        BankAccountRemote service = new BankAccountRemoteImpl();

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("BankAccountService", service);

        Logger.log("RMI server started. Service bound as 'BankAccountService'");
    }
}
