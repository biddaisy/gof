package com.github.biddaisy.gof.structural.facade.bank;

import com.github.biddaisy.gof.Logger;

/**
 * Provides credit scoring for loan decisions.
 */
public class CreditScoreService {

    public int getCreditScore(String customerId) {
        Logger.debug("Fetching credit score for customer {0}", customerId);
        return 720; // pretend good score
    }
}
