package com.mr.gof.structural.proxy.bank.rmi;

import com.mr.gof.Logger;

import java.math.BigDecimal;
import java.rmi.RemoteException;

/**
 * Remote Proxy (client-side stub).
 * Wraps the remote object and simulates network behavior.
 */
public class BankAccountRemoteProxy implements BankAccountRemote {

    private final BankAccountRemote remote;

    public BankAccountRemoteProxy(BankAccountRemote remote) {
        this.remote = remote;
    }

    @Override
    public BigDecimal getBalance(String accountId) throws RemoteException {
        Logger.log("[PROXY] Calling remote getBalance({0})", accountId);
        return remote.getBalance(accountId);
    }

    @Override
    public void deposit(String accountId, BigDecimal amount) throws RemoteException {
        Logger.log("[PROXY] Calling remote deposit({0}, {1})", accountId, amount);
        remote.deposit(accountId, amount);
    }

    @Override
    public void withdraw(String accountId, BigDecimal amount) throws RemoteException {
        Logger.log("[PROXY] Calling remote withdraw({0}, {1})", accountId, amount);
        remote.withdraw(accountId, amount);
    }
}
