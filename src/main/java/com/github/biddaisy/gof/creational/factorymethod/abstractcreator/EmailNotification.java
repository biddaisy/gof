package com.github.biddaisy.gof.creational.factorymethod.abstractcreator;

import com.github.biddaisy.gof.Logger;

/**
 * Concrete Product: Email notification.
 */
public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        Logger.log("Sending EMAIL: " + message);
    }
}