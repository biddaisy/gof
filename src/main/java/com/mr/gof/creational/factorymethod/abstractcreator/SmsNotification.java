package com.mr.gof.creational.factorymethod.abstractcreator;

import com.mr.gof.Logger;

/**
 * Concrete Product: SMS notification.
 */
public class SmsNotification implements Notification {

    @Override
    public void send(String message) {
        Logger.log("Sending SMS: " + message);
    }

}
