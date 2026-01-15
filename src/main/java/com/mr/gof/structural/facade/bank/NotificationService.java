package com.mr.gof.structural.facade.bank;

import com.mr.gof.Logger;

/**
 * Sends notifications to customers.
 */
public class NotificationService {

    public void notify(String customerId, String message) {
        Logger.log("Notify {0}: {1}", customerId, message);
    }
}
