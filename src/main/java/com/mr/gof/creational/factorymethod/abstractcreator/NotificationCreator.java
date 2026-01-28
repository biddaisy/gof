package com.mr.gof.creational.factorymethod.abstractcreator;

/**
 * Abstract Creator.
 * <p>
 * Declares the factory method but does NOT implement it.
 * Subclasses MUST provide the concrete product creation logic.
 * <p>
 * This variation is used when the base class cannot know
 * which product subclass should be instantiated.
 */
public abstract class NotificationCreator {

    // Factory Method — abstract, no default implementation
    protected abstract Notification createNotification();

    /**
     * Business logic that uses the product.
     * The Creator relies on the factory method to obtain the product.
     */
    public void notifyCustomer(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}
