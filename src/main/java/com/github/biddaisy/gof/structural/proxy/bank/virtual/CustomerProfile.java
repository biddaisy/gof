package com.github.biddaisy.gof.structural.proxy.bank.virtual;

/**
 * Subject interface for customer profile access.
 */
public interface CustomerProfile {
    String getCustomerId();

    String getFullName();

    String getRiskRating();

    String getKycDocument();
}
