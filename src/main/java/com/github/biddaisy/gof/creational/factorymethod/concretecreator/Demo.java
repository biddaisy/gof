package com.github.biddaisy.gof.creational.factorymethod.concretecreator;

/**
 * Demonstrates the Factory Method where the Creator is concrete
 * and provides a default factory method implementation.
 */
public class Demo {
    public static void main(String[] args) {

        // Uses default PushAlert
        AlertManager defaultManager = new AlertManager();
        defaultManager.processAlert("System maintenance at 2 AM.");

        // Subclass overrides to use SMS alerts
        AlertManager smsManager = new SmsAlertManager();
        smsManager.processAlert("Fraud detected on your account.");
    }
}
