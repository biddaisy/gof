package com.mr.gof.structural.flyweight.bank;

/**
 * Immutable flyweight for bank branch metadata.
 */
public record BankBranch(String branchId, String address, String city, String country) implements BankBranchFlyweight {

}
