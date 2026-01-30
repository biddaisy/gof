package com.github.biddaisy.gof.structural.flyweight.bank;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Factory ensuring reuse of BankBranch flyweights.
 */
public class BankBranchFactory {

    private static final Map<String, BankBranchFlyweight> CACHE = new ConcurrentHashMap<>();

    private BankBranchFactory() {
    }

    public static BankBranchFlyweight get(String branchId) {
        return CACHE.computeIfAbsent(branchId, BankBranchFactory::create);
    }

    private static BankBranchFlyweight create(String id) {
        return switch (id) {
            case "BR-001" -> new BankBranch("BR-001", "1 Wall Street", "New York", "USA");
            case "BR-002" -> new BankBranch("BR-002", "221B Baker Street", "London", "UK");
            case "BR-003" -> new BankBranch("BR-003", "Shinjuku 5-2-1", "Tokyo", "Japan");
            default -> throw new IllegalArgumentException("Unknown branch: " + id);
        };
    }
}
