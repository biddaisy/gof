package com.github.biddaisy.gof.structural.facade.bank;

import com.github.biddaisy.gof.Logger;

/**
 * Sends notifications to customers.
 */
public class NotificationService {

    public void notify(String customerId, String message) {
        Logger.log("Notify {0}: {1}", customerId, message);
    }
}
