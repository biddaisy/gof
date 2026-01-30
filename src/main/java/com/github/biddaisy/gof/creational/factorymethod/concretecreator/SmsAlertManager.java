package com.github.biddaisy.gof.creational.factorymethod.concretecreator;

/**
 * Subclass that overrides the default factory method
 * to produce SMS alerts instead of push alerts.
 */
public class SmsAlertManager extends AlertManager {
    @Override
    protected Alert createAlert() {
        return new SmsAlert();
    }
}
