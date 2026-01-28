package com.mr.gof.creational.factorymethod.concretecreator;

import static com.mr.gof.Logger.log;

/**
 * Default alert type: Push notification.
 */
public class PushAlert implements Alert {
    @Override
    public void trigger(String message) {
        log("PUSH ALERT: " + message);
    }
}