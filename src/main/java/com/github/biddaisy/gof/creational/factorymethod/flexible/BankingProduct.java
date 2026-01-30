package com.github.biddaisy.gof.creational.factorymethod.flexible;

/**
 * Base Product interface for all banking domain objects.
 * Each product simulates loading its state (e.g., from a database or file).
 */
public interface BankingProduct {
    void load();
}
