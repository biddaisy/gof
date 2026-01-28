package com.mr.gof.creational.factorymethod.abstractcreator;

/**
 * Product interface for all notification types.
 * Concrete products (Email, SMS, etc.) implement this.
 */
public interface Notification {
    void send(String message);
}
