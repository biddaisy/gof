package com.mr.gof.structural.flyweight.bank;

/**
 * Immutable flyweight for transaction types.
 */
public record TransactionType(String code, String description,
                              boolean requiresApproval) implements TransactionTypeFlyweight {

}
