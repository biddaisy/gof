package com.github.biddaisy.gof.creational.factorymethod.parameterized;

import static com.github.biddaisy.gof.creational.factorymethod.parameterized.ProductType.*;

/**
 * Subclass that overrides the parameterized factory method.
 * <p>
 * Demonstrates:
 * - Swapping product mappings (ACCOUNT ↔ LOAN)
 * - Adding a new product type (INVESTMENT)
 * - Delegating to parent for unknown types
 */
public class AdvancedBankingProductCreator extends BankingProductCreator {

    @Override
    public BankingProduct create(ProductType type) {

        // Swap ACCOUNT and LOAN mappings
        if (type == ACCOUNT) {
            return new Loan(); // swapped
        }

        if (type == LOAN) {
            return new BankAccount(); // swapped
        }

        // Add new product type (INVESTMENT)
        if (type == INVESTMENT) {
            return new InvestmentAccount();
        }

        // Delegate to parent for all other types (e.g., CARD)
        return super.create(type);
    }
}
