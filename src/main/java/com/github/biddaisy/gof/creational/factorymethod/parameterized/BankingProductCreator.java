package com.github.biddaisy.gof.creational.factorymethod.parameterized;

/**
 * Creator class with a parameterized factory method.
 *
 * This version supports multiple parameterized product types based on an identifier.
 * Mirrors the GoF parameterized factory method pattern.
 */
public class BankingProductCreator {

    /**
     * Parameterized Factory Method.
     *
     * Creates different BankingProduct types based on the ProductType parameter.
     */
    public BankingProduct create(ProductType type) {

        if (type == ProductType.ACCOUNT) {
            return new BankAccount();
        }

        if (type == ProductType.LOAN) {
            return new Loan();
        }

        if (type == ProductType.CARD) {
            return new Card();
        }

        return null; // Unknown type
    }
}
