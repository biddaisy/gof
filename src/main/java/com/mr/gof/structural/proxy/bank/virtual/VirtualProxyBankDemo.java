package com.mr.gof.structural.proxy.bank.virtual;

import com.mr.gof.Logger;

/**
 * Demonstrates the Virtual Proxy pattern in a banking context.
 */
public class VirtualProxyBankDemo {

    private VirtualProxyBankDemo() {
    }

    static void main() {

        Logger.log("=== Creating proxy ===");
        CustomerProfile profile = new CustomerProfileProxy("CUST-1001");

        Logger.log("Customer ID available immediately: {0}", profile.getCustomerId());

        Logger.log("=== Accessing heavy data ===");
        Logger.log("Full name: {0}", profile.getFullName());
        Logger.log("Risk rating: {0}", profile.getRiskRating());
        Logger.log("KYC document: {0}", profile.getKycDocument());
    }
}
