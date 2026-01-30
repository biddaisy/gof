package com.github.biddaisy.gof.creational.factorymethod.abstractcreator;

/**
 * Demonstrates the Factory Method where the Creator is abstract
 * and subclasses MUST implement the factory method.
 */
public class Demo {
    public static void main(String[] args) {

        NotificationCreator emailCreator = new EmailNotificationCreator();
        emailCreator.notifyCustomer("Your account balance is low.");

        NotificationCreator smsCreator = new SmsNotificationCreator();
        smsCreator.notifyCustomer("Your OTP code is 123456.");
    }
}
