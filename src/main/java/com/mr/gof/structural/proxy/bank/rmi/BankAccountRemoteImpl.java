package com.mr.gof.structural.proxy.bank.rmi;

import com.mr.gof.Logger;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Real Subject running on the remote server.
 */
public class BankAccountRemoteImpl extends UnicastRemoteObject implements BankAccountRemote {

    private final Map<String, BigDecimal> balances = new ConcurrentHashMap<>();

    public BankAccountRemoteImpl() throws RemoteException {
        super();
        balances.put("ACC-1001", new BigDecimal("1000.00"));
        balances.put("ACC-2002", new BigDecimal("250.50"));
    }

    @Override
    public BigDecimal getBalance(String accountId) throws RemoteException {
        Logger.log("[REMOTE SERVER] getBalance({0})", accountId);
        return balances.getOrDefault(accountId, BigDecimal.ZERO);
    }

    @Override
    public void deposit(String accountId, BigDecimal amount) throws RemoteException {
        Logger.log("[REMOTE SERVER] deposit({0}, {1})", accountId, amount);
        balances.merge(accountId, amount, BigDecimal::add);
    }

    @Override
    public void withdraw(String accountId, BigDecimal amount) throws RemoteException {
        Logger.log("[REMOTE SERVER] withdraw({0}, {1})", accountId, amount);
        balances.merge(accountId, amount.negate(), BigDecimal::add);
    }
}
