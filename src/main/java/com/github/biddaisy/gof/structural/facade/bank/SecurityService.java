package com.github.biddaisy.gof.structural.facade.bank;

import com.github.biddaisy.gof.Logger;

/**
 * Verifies customer identity before performing sensitive operations.
 */
public class SecurityService {

    public boolean verifyIdentity(String customerId) {
        Logger.debug("Verifying identity for customer {0}", customerId);
        return true; // assume identity is valid
    }
}
