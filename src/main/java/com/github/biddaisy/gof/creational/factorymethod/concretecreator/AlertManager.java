package com.github.biddaisy.gof.creational.factorymethod.concretecreator;

/**
 * Concrete Creator with a DEFAULT factory method implementation.
 *
 * Subclasses may override the factory method to change the product type,
 * but they are not required to.
 *
 * This variation is used when the base class has a reasonable default,
 * but designers want to allow subclasses to customize object creation.
 */
public class AlertManager {

    // Factory Method — default implementation
    protected Alert createAlert() {
        return new PushAlert(); // default product
    }

    /**
     * Business logic that uses the product created by the factory method.
     */
    public void processAlert(String message) {
        Alert alert = createAlert();
        alert.trigger(message);
    }
}
