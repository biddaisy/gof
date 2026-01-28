package com.mr.gof.creational.factorymethod.flexible;

import static com.mr.gof.Logger.log;

/**
 * Thread-safe Smalltalk-style Factory Method variant for banking products.
 *
 * The class to instantiate is stored in a volatile field.
 * - No subclassing required to change product type.
 * - Product type can be changed at runtime.
 * - Safe under concurrent access.
 */
public class ConfigurableBankingSystem {

    /**
     * Holds the class of the BankingProduct to instantiate.
     *
     * volatile ensures:
     *  - visibility across threads
     *  - safe publication of updates
     */
    private volatile Class<? extends BankingProduct> productClass;

    /**
     * Constructor initializes the product class.
     */
    public ConfigurableBankingSystem(Class<? extends BankingProduct> productClass) {
        this.productClass = productClass;
    }

    /**
     * Thread-safe reconfiguration of the product type.
     *
     * synchronized ensures atomic update and prevents race conditions
     * when multiple threads attempt to change the class simultaneously.
     */
    public synchronized void setProductClass(Class<? extends BankingProduct> productClass) {
        this.productClass = productClass;
    }

    /**
     * Factory Method.
     *
     * Thread-safe because:
     *  - productClass is volatile (visible to all threads)
     *  - instantiation uses a local copy of the volatile reference
     */
    public BankingProduct createProduct() {
        Class<? extends BankingProduct> clazz = this.productClass; // volatile read

        try {
            BankingProduct bankingProduct = clazz.getDeclaredConstructor().newInstance();
            log("Banking product created: " + bankingProduct.getClass().getSimpleName());
            return bankingProduct;
        } catch (Exception e) {
            throw new RuntimeException("Cannot instantiate banking product", e);
        }
    }
}
