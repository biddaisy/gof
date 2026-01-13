package com.mr.gof.structural.composite.bank;

import com.mr.gof.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Higher-level Composite Class in the Composite Pattern.
 * <p>
 * Represents a customer's entire portfolio of accounts.
 * This can contain both IndividualAccounts and JointAccounts,
 * demonstrating the flexibility of the composite pattern.
 *
 * <p>This class extends the Composite Pattern by:
 * <ul>
 *   <li>Being a "composite of composites" (can contain both leaves and other composites)</li>
 *   <li>Providing customer-level operations and reporting</li>
 *   <li>Demonstrating how composites can have specialized business logic</li>
 *   <li>Showing multiple levels of hierarchy in action</li>
 * </ul>
 *
 * <p>Key characteristics:
 * <ul>
 *   <li>Highest level in the account hierarchy for a customer</li>
 *   <li>Can contain any type of BankAccount</li>
 *   <li>Provides portfolio-level business logic (interest calculation, summaries)</li>
 *   <li>Demonstrates the power of recursive composition</li>
 * </ul>
 *
 * <p>Design decisions:
 * <ol>
 *   <li>Implements both composite behavior and customer-specific logic</li>
 *   <li>Uses inner class for portfolio summary (encapsulation)</li>
 *   <li>Provides rich reporting capabilities</li>
 *   <li>Logs all portfolio operations</li>
 * </ol>
 */
public class CustomerPortfolio implements BankAccount {
    private final String customerName;
    private final List<BankAccount> accounts;

    /**
     * Creates a new customer portfolio.
     *
     * @param customerName the name of the customer
     */
    public CustomerPortfolio(String customerName) {
        this.customerName = customerName;
        this.accounts = new ArrayList<>();
        Logger.debug("Created CustomerPortfolio for {0}", customerName);
    }

    /**
     * Returns the portfolio name.
     *
     * @return the customer's portfolio name
     */
    @Override
    public String getName() {
        return customerName + "'s Portfolio";
    }

    /**
     * Calculates the customer's total net worth.
     * <p>
     * Aggregates balances from all accounts in the portfolio.
     * Demonstrates recursive aggregation across multiple composite levels.
     *
     * @return total balance across all accounts
     */
    @Override
    public BigDecimal getBalance() {
        BigDecimal total = BigDecimal.ZERO;
        for (BankAccount account : accounts) {
            // Recursive call: each account handles its own balance calculation
            total = total.add(account.getBalance());
        }
        Logger.debug("Calculated portfolio balance for {0}: ${1}",
                customerName, total);
        return total;
    }

    /**
     * Displays the entire portfolio hierarchy.
     * <p>
     * Shows customer-level summary followed by all accounts.
     * This is the entry point for displaying a customer's complete financial picture.
     *
     * @param indent the indentation string for hierarchy display
     */
    @Override
    public void display(String indent) {
        Logger.log("{0}🏦 {1}'s Total Portfolio: ${2}",
                indent, customerName, getBalance());

        // Display all accounts with indentation
        // Each account handles its own display recursively
        for (BankAccount account : accounts) {
            account.display(indent + "  ");
        }
    }

    /**
     * Adds an account to the customer's portfolio.
     *
     * @param account the account to add
     */
    public void addAccount(BankAccount account) {
        accounts.add(account);
        Logger.debug("Added {0} to {1}'s portfolio",
                account.getName(), customerName);
    }

    /**
     * Removes an account from the portfolio.
     *
     * @param account the account to remove
     * @return true if removed, false if not found
     */
    public boolean removeAccount(BankAccount account) {
        boolean removed = accounts.remove(account);
        if (removed) {
            Logger.debug("Removed {0} from {1}'s portfolio",
                    account.getName(), customerName);
        }
        return removed;
    }

    /**
     * Business method specific to customer portfolios.
     * <p>
     * Calculates total annual interest for all accounts in the portfolio.
     * Assumes same interest rate applies to all accounts (simplified model).
     *
     * @param annualRate the annual interest rate (e.g., 3.5 for 3.5%)
     * @return total annual interest
     */
    public BigDecimal getTotalAnnualInterest(double annualRate) {
        BigDecimal interest = getBalance().multiply(BigDecimal.valueOf(annualRate / 100));
        Logger.debug("Calculated annual interest for {0}: ${1} at {2}%",
                customerName, interest, annualRate);
        return interest;
    }

    /**
     * Business method specific to customer portfolios.
     * <p>
     * Returns a summary of account types in the portfolio.
     * Demonstrates how composites can provide rich business intelligence.
     *
     * @return PortfolioSummary object containing counts and analysis
     */
    public PortfolioSummary getPortfolioSummary() {
        int individualCount = 0;
        int jointCount = 0;
        BigDecimal maxBalance = BigDecimal.ZERO;
        BankAccount largestAccount = null;

        // Analyze all accounts in the portfolio
        for (BankAccount account : accounts) {
            if (account instanceof IndividualAccount) {
                individualCount++;
            } else if (account instanceof JointAccount) {
                jointCount++;
            }

            // Track the largest account (by balance)
            if (account.getBalance().compareTo(maxBalance) > 0) {
                maxBalance = account.getBalance();
                largestAccount = account;
            }
        }

        Logger.debug("Generated portfolio summary for {0}: {1} individual, {2} joint accounts",
                customerName, individualCount, jointCount);

        return new PortfolioSummary(individualCount, jointCount,
                accounts.size(), largestAccount);
    }

    /**
     * Returns the customer name.
     *
     * @return customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Returns number of accounts in portfolio.
     *
     * @return account count
     */
    public int getAccountCount() {
        return accounts.size();
    }

    /**
     * Inner class for portfolio summary data.
     * <p>
     * Demonstrates encapsulation and rich domain modeling.
     * Provides a clean API for portfolio analysis results.
     */
    public class PortfolioSummary {
        private final int individualAccountCount;
        private final int jointAccountCount;
        private final int totalAccountCount;
        private final BankAccount largestAccount;

        /**
         * Creates a new portfolio summary.
         *
         * @param individualCount number of individual accounts
         * @param jointCount number of joint accounts
         * @param totalCount total number of accounts
         * @param largestAccount the account with the largest balance
         */
        public PortfolioSummary(int individualCount, int jointCount,
                                int totalCount, BankAccount largestAccount) {
            this.individualAccountCount = individualCount;
            this.jointAccountCount = jointCount;
            this.totalAccountCount = totalCount;
            this.largestAccount = largestAccount;
        }

        /**
         * Prints the portfolio summary using the Logger.
         */
        public void printSummary() {
            Logger.log("Portfolio Summary for {0}:", customerName);
            Logger.log("  Individual Accounts: {0}", individualAccountCount);
            Logger.log("  Joint Accounts: {0}", jointAccountCount);
            Logger.log("  Total Accounts: {0}", totalAccountCount);
            if (largestAccount != null) {
                Logger.log("  Largest Account: {0} (${1})",
                        largestAccount.getName(), largestAccount.getBalance());
            }
        }

        // Getters for programmatic access
        public int getIndividualAccountCount() { return individualAccountCount; }
        public int getJointAccountCount() { return jointAccountCount; }
        public int getTotalAccountCount() { return totalAccountCount; }
        public BankAccount getLargestAccount() { return largestAccount; }
    }
}