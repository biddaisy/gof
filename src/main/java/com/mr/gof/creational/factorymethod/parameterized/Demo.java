package com.mr.gof.creational.factorymethod.parameterized;

import com.mr.gof.Logger;

/**
 * Demonstrates the Parameterized Factory Method pattern in a parameterized domain.
 *
 * Shows:
 *  - Base creator producing standard parameterized products
 *  - Subclass creator overriding mappings
 *  - Subclass adding new product types
 *  - Delegation to parent for unknown identifiers
 */
public class Demo {

    public static void main(String[] args) {

        BankingProductCreator baseCreator = new BankingProductCreator();
        BankingProductCreator advancedCreator = new AdvancedBankingProductCreator();

        Logger.log("--- Base Creator ---");
        baseCreator.create(ProductType.ACCOUNT).load();
        baseCreator.create(ProductType.LOAN).load();
        baseCreator.create(ProductType.CARD).load();

        Logger.log("\n--- Advanced Creator (Overridden) ---");
        advancedCreator.create(ProductType.ACCOUNT).load(); // swapped
        advancedCreator.create(ProductType.LOAN).load();    // swapped
        advancedCreator.create(ProductType.CARD).load();    // delegated

        Logger.log("\n--- Advanced Creator (New Product) ---");
        BankingProduct investment =
                advancedCreator.create(ProductType.valueOf("INVESTMENT"));
        investment.load();
    }
}
