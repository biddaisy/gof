package com.mr.gof.creational.factorymethod.abstractcreator;

/**
 * Concrete Creator that produces SmsNotification objects.
 */
public class SmsNotificationCreator extends NotificationCreator {
    @Override
    protected Notification createNotification() {
        return new SmsNotification();
    }
}
