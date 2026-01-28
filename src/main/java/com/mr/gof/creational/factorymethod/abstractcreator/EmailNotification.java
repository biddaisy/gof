package com.mr.gof.creational.factorymethod.abstractcreator;

import com.mr.gof.Logger;

/**
 * Concrete Product: Email notification.
 */
public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        Logger.log("Sending EMAIL: " + message);
    }
}