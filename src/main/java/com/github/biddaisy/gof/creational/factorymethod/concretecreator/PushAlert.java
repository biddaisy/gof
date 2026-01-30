package com.github.biddaisy.gof.creational.factorymethod.concretecreator;

import static com.github.biddaisy.gof.Logger.log;

/**
 * Default alert type: Push notification.
 */
public class PushAlert implements Alert {
    @Override
    public void trigger(String message) {
        log("PUSH ALERT: " + message);
    }
}