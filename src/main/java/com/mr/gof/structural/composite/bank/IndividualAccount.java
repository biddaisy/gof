package com.mr.gof.structural.composite.bank;

import com.mr.gof.Logger;

import java.math.BigDecimal;

/**
 * Leaf Class in the Composite Pattern.
 * <p>
 * Represents a single, individual bank account that cannot contain
 * other accounts. This is a terminal node in the account hierarchy.
 *
 * <p>This class implements the Leaf role in the Composite Pattern:
 * <ul>
 *   <li>Represents leaf objects in the composition (no children)</li>
 *   <li>Defines behavior for primitive objects in the composition</li>
 *   <li>Implements all Component interface operations directly</li>
 * </ul>
 *
 * <p>Key characteristics:
 * <ul>
 *   <li>Cannot have child accounts (throws exceptions for add/remove operations)</li>
 *   <li>Contains actual balance data (state)</li>
 *   <li>Implements all operations directly without delegation</li>
 *   <li>Represents the smallest unit in the account hierarchy</li>
 * </ul>
 *
 * <p>Design decisions:
 * <ol>
 *   <li>Uses BigDecimal for financial precision (avoids floating-point errors)</li>
 *   <li>Logs all operations for audit trail and debugging</li>
 *   <li>Provides business-specific methods (calculateInterest, applyTransaction)</li>
 *   <li>Throws UnsupportedOperationException for composite operations (add/remove)</li>
 * </ol>
 *
 * <p>This class demonstrates the "leaf" part of the "leaf-composite" structure.
 */
public class IndividualAccount implements BankAccount {
    private final String accountHolder;
    private BigDecimal balance;

    /**
     * Creates a new individual bank account.
     * <p>
     * Constructor logs the creation for audit purposes.
     *
     * @param accountHolder the name of the account holder
     * @param balance the initial account balance (must be non-negative)
     */
    public IndividualAccount(String accountHolder, BigDecimal balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        // Debug logging for object creation
        Logger.debug("Created IndividualAccount for {0} with balance ${1}",
                accountHolder, balance);
    }

    /**
     * Returns the account name in format "Holder's Account".
     * <p>
     * Demonstrates simple leaf behavior - no recursion needed.
     *
     * @return the formatted account name
     */
    @Override
    public String getName() {
        return accountHolder + "'s Account";
    }

    /**
     * Returns the actual balance of this individual account.
     * <p>
     * This is a leaf operation that doesn't need to traverse children.
     * Logs the operation for audit trail.
     *
     * @return the account balance
     */
    @Override
    public BigDecimal getBalance() {
        // Debug logging shows when this method is called
        Logger.debug("Getting balance for {0}: ${1}", accountHolder, balance);
        return balance;
    }

    /**
     * Displays this individual account with appropriate formatting.
     * <p>
     * Uses 👤 emoji for visual distinction from composite accounts.
     * This is the leaf implementation of the recursive display operation.
     *
     * @param indent the indentation string for hierarchy display
     */
    @Override
    public void display(String indent) {
        Logger.log("{0}👤 {1}: ${2}", indent, accountHolder, balance);
    }

    /**
     * Business method specific to individual accounts.
     * <p>
     * Calculates annual interest for this specific account.
     * Demonstrates that leaf classes can have their own business logic.
     *
     * @param annualRate the annual interest rate (e.g., 3.5 for 3.5%)
     * @return the annual interest amount
     */
    public BigDecimal calculateInterest(double annualRate) {
        BigDecimal interest = balance.multiply(BigDecimal.valueOf(annualRate / 100));
        Logger.debug("Calculated interest for {0}: ${1} at {2}%",
                accountHolder, interest, annualRate);
        return interest;
    }

    /**
     * Business method specific to individual accounts.
     * <p>
     * Applies a transaction (deposit or withdrawal) to this account.
     * Demonstrates business logic with proper error handling and logging.
     *
     * @param amount the transaction amount (positive for deposit, negative for withdrawal)
     * @return the new balance after transaction
     * @throws IllegalArgumentException if withdrawal exceeds balance (insufficient funds)
     */
    public BigDecimal applyTransaction(BigDecimal amount) {
        BigDecimal newBalance = balance.add(amount);

        // Business rule: balance cannot be negative
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            Logger.error("Transaction failed for {0}: Insufficient funds. Current: ${1}, Attempted: ${2}",
                    accountHolder, balance, amount);
            throw new IllegalArgumentException("Insufficient funds");
        }

        // Update balance and log success
        balance = newBalance;
        Logger.log("Transaction applied for {0}: ${1}. New balance: ${2}",
                accountHolder, amount, balance);
        return balance;
    }

    /**
     * Returns the account holder name.
     * <p>
     * Utility method for business logic that needs the raw holder name.
     *
     * @return the account holder's name
     */
    public String getAccountHolder() {
        return accountHolder;
    }

    /**
     * String representation for debugging.
     *
     * @return string representation of this individual account
     */
    @Override
    public String toString() {
        return "IndividualAccount{holder='" + accountHolder + "', balance=" + balance + "}";
    }
}