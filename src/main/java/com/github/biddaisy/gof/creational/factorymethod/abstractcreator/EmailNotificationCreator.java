package com.github.biddaisy.gof.creational.factorymethod.abstractcreator;

/**
 * Concrete Creator that produces EmailNotification objects.
 */
public class EmailNotificationCreator extends NotificationCreator {
    @Override
    protected Notification createNotification() {
        return new EmailNotification();
    }
}
