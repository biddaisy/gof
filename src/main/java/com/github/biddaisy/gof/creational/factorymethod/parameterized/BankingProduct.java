package com.github.biddaisy.gof.creational.factorymethod.parameterized;

/**
 * Base Product interface for all parameterized domain objects.
 * Each product knows how to load its own state (simulating reconstruction from disk).
 */
public interface BankingProduct {
    void load();
}
