package com.github.biddaisy.gof.structural.proxy.bank.virtual;

import com.github.biddaisy.gof.Logger;

/**
 * Thread-safe Virtual Proxy using double-checked locking.
 */
public class CustomerProfileProxy implements CustomerProfile {

    private final String customerId;

    // Must be volatile for correct double-checked locking
    private volatile RealCustomerProfile realProfile;

    public CustomerProfileProxy(String customerId) {
        this.customerId = customerId;
    }

    private RealCustomerProfile getRealProfile() {
        RealCustomerProfile localRef = realProfile;

        if (localRef == null) { // First check (no locking)
            synchronized (this) {
                localRef = realProfile;
                if (localRef == null) { // Second check (with locking)
                    Logger.log("[PROXY] Lazy-loading RealCustomerProfile (thread-safe)...");
                    realProfile = localRef = new RealCustomerProfile(customerId);
                }
            }
        }

        return localRef;
    }

    @Override
    public String getCustomerId() {
        return customerId; // available without loading
    }

    @Override
    public String getFullName() {
        return getRealProfile().getFullName();
    }

    @Override
    public String getRiskRating() {
        return getRealProfile().getRiskRating();
    }

    @Override
    public String getKycDocument() {
        return getRealProfile().getKycDocument();
    }
}
