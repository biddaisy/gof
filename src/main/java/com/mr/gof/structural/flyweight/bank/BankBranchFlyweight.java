package com.mr.gof.structural.flyweight.bank;

/**
 * Flyweight representing immutable bank branch metadata.
 */
public interface BankBranchFlyweight {
    String branchId();
    String address();
    String city();
    String country();
}
