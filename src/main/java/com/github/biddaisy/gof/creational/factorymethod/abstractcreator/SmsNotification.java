package com.github.biddaisy.gof.creational.factorymethod.abstractcreator;

import com.github.biddaisy.gof.Logger;

/**
 * Concrete Product: SMS notification.
 */
public class SmsNotification implements Notification {

    @Override
    public void send(String message) {
        Logger.log("Sending SMS: " + message);
    }

}
