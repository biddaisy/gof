package com.github.biddaisy.gof.creational.factorymethod.concretecreator;

import static com.github.biddaisy.gof.Logger.log;

/**
 * Alternative alert type: SMS alert.
 */
public class SmsAlert implements Alert {
    @Override
    public void trigger(String message) {
        log("SMS ALERT: " + message);
    }
}
