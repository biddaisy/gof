package com.github.biddaisy.gof.structural.flyweight.bank;

/**
 * Flyweight representing intrinsic transaction type metadata.
 */
public interface TransactionTypeFlyweight {
    String code();
    String description();
    boolean requiresApproval();
}
