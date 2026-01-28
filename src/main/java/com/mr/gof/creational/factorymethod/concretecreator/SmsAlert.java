package com.mr.gof.creational.factorymethod.concretecreator;

import static com.mr.gof.Logger.log;

/**
 * Alternative alert type: SMS alert.
 */
public class SmsAlert implements Alert {
    @Override
    public void trigger(String message) {
        log("SMS ALERT: " + message);
    }
}
