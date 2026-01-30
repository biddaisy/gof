package com.github.biddaisy.gof.creational.prototype.banking;

/**
 * Abstract Prototype for all banking domain objects.
 *
 * Each concrete product (Account, Loan, Card) must support cloning.
 * The Prototype pattern allows the system to create new banking objects
 * by copying preconfigured prototype instances instead of instantiating
 * subclasses directly.
 */
public abstract class BankingProduct implements Cloneable {

    /**
     * Displays product information.
     * Concrete subclasses define their own representation.
     */
    public abstract void display();

    /**
     * Prototype cloning operation.
     *
     * Uses Object.clone() to produce a shallow copy.
     * Subclasses may override for deep cloning if needed.
     */
    public BankingProduct cloneProduct() {
        try {
            return (BankingProduct) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone failed", e);
        }
    }
}
