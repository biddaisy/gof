package com.github.biddaisy.gof.structural.facade.bank;

import com.github.biddaisy.gof.Logger;

import java.math.BigDecimal;

/**
 * Facade that orchestrates complex parameterized operations such as:
 * - KYC verification
 * - AML screening
 * - Identity verification
 * - Credit scoring
 * - Account transfers
 * - Loan applications
 *
 * Clients interact only with this class, not the underlying subsystems.
 */
public class BankFacade {

    private final KYCService kycService = new KYCService();
    private final AMLService amlService = new AMLService();
    private final CreditScoreService creditScoreService = new CreditScoreService();
    private final SecurityService securityService = new SecurityService();
    private final AccountService accountService = new AccountService();
    private final NotificationService notificationService = new NotificationService();

    /**
     * Opens a new customer account after performing KYC and AML checks.
     */
    public void onboardCustomer(String customerId) {
        Logger.log("=== Onboarding customer {0} ===", customerId);

        if (!kycService.isKYCComplete(customerId)) {
            Logger.warn("Onboarding failed: KYC incomplete");
            return;
        }

        if (!amlService.isCustomerClean(customerId)) {
            Logger.warn("Onboarding failed: AML screening failed");
            return;
        }

        notificationService.notify(customerId, "Welcome! Your onboarding is complete.");
        Logger.log("Customer {0} successfully onboarded", customerId);
    }

    /**
     * Transfers money between accounts with AML and identity checks.
     */
    public void transferMoney(String customerId, String fromAcc, String toAcc, BigDecimal amount) {
        Logger.log("=== Transfer Request by {0}: {1} -> {2}, amount: {3} ===",
                customerId, fromAcc, toAcc, amount);

        if (!securityService.verifyIdentity(customerId)) {
            Logger.warn("Transfer denied: identity verification failed");
            return;
        }

        if (!amlService.isTransactionAllowed(amount)) {
            Logger.warn("Transfer denied: AML threshold exceeded");
            return;
        }

        if (!accountService.hasSufficientBalance(fromAcc, amount)) {
            Logger.warn("Transfer denied: insufficient funds");
            return;
        }

        accountService.debit(fromAcc, amount);
        accountService.credit(toAcc, amount);

        notificationService.notify(customerId, "You transferred " + amount);
        Logger.log("Transfer completed successfully");
    }

    /**
     * Applies for a loan using identity verification, AML, and credit scoring.
     */
    public void applyForLoan(String customerId, double amount) {
        Logger.log("=== Loan Application: customer {0}, amount {1} ===", customerId, amount);

        if (!securityService.verifyIdentity(customerId)) {
            Logger.warn("Loan denied: identity verification failed");
            return;
        }

        if (!amlService.isCustomerClean(customerId)) {
            Logger.warn("Loan denied: AML screening failed");
            return;
        }

        int score = creditScoreService.getCreditScore(customerId);
        Logger.debug("Credit score for {0} is {1}", customerId, score);

        if (score < 650) {
            Logger.warn("Loan denied: insufficient credit score");
            return;
        }

        notificationService.notify(customerId, "Loan approved for amount: " + amount);
        Logger.log("Loan approved");
    }
}
