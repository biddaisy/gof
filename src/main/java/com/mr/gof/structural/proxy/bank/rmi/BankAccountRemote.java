package com.mr.gof.structural.proxy.bank.rmi;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface for bank account operations.
 * This is the Subject in the Proxy pattern.
 */
public interface BankAccountRemote extends Remote {

    BigDecimal getBalance(String accountId) throws RemoteException;

    void deposit(String accountId, BigDecimal amount) throws RemoteException;

    void withdraw(String accountId, BigDecimal amount) throws RemoteException;
}
