package com.mr.gof.structural.proxy.bank.virtual;

import com.mr.gof.Logger;

/**
 * Heavy object that simulates expensive loading from a remote system.
 */
public class RealCustomerProfile implements CustomerProfile {

    private final String customerId;
    private final String fullName;
    private final String riskRating;
    private final String kycDocument;

    public RealCustomerProfile(String customerId) {
        this.customerId = customerId;

        Logger.log("[REAL] Loading customer profile from remote system...");
        simulateSlowLoad();

        this.fullName = "John Doe";
        this.riskRating = "LOW";
        this.kycDocument = "KYC-PDF-DATA";
    }

    private void simulateSlowLoad() {
        try {
            Thread.sleep(2000); // 2 seconds
        } catch (InterruptedException ignored) {
        }
    }

    @Override
    public String getCustomerId() {
        return customerId;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getRiskRating() {
        return riskRating;
    }

    @Override
    public String getKycDocument() {
        return kycDocument;
    }
}
