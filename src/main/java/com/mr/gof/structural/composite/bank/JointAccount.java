package com.mr.gof.structural.composite.bank;

import com.mr.gof.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Composite Class in the Composite Pattern.
 * <p>
 * Represents a joint bank account that can contain multiple individual accounts.
 * This is a composite node that delegates operations to its children.
 *
 * <p>This class implements the Composite role in the Composite Pattern:
 * <ul>
 *   <li>Defines behavior for components having children</li>
 *   <li>Stores child components (other BankAccount objects)</li>
 *   <li>Implements child-related operations (add, remove, getChildren)</li>
 *   <li>Delegates operations like getBalance() to child components</li>
 * </ul>
 *
 * <p>Key characteristics:
 * <ul>
 *   <li>Can contain child accounts (both IndividualAccount and other JointAccount)</li>
 *   <li>Aggregates results from child accounts</li>
 *   <li>Implements add/remove operations for child management</li>
 *   <li>Delegates operations to children (recursive traversal)</li>
 *   <li>Maintains the parent-child relationships in the hierarchy</li>
 * </ul>
 *
 * <p>Design decisions:
 * <ol>
 *   <li>Uses composition over inheritance (contains List<BankAccount>)</li>
 *   <li>Implements recursive operations for hierarchy traversal</li>
 *   <li>Provides both composite operations and business-specific methods</li>
 *   <li>Logs all operations for transparency and debugging</li>
 *   <li>Uses defensive copying for getter methods</li>
 * </ol>
 */
public class JointAccount implements BankAccount {
    private final String accountName;
    private final List<BankAccount> accounts;

    /**
     * Creates a new joint bank account.
     * <p>
     * Initializes an empty list of child accounts.
     * Logs creation for audit trail.
     *
     * @param accountName the name of the joint account (e.g., "Family Savings")
     */
    public JointAccount(String accountName) {
        this.accountName = accountName;
        this.accounts = new ArrayList<>();
        Logger.debug("Created JointAccount: {0}", accountName);
    }

    /**
     * Returns the name of this joint account.
     * <p>
     * Simple property accessor - no recursion needed.
     *
     * @return the joint account name
     */
    @Override
    public String getName() {
        return accountName;
    }

    /**
     * Calculates the total balance by summing all child account balances.
     * <p>
     * This demonstrates recursive aggregation in composite pattern.
     *
     * <p>Algorithm:
     * <ol>
     *   <li>Start with zero total</li>
     *   <li>For each child account, get its balance (recursive call)</li>
     *   <li>Sum all balances</li>
     * </ol>
     *
     * <p>Time Complexity: O(n) where n is total number of accounts in hierarchy
     * <br>Space Complexity: O(h) for recursion stack where h is hierarchy depth
     *
     * @return the sum of all child account balances
     */
    @Override
    public BigDecimal getBalance() {
        BigDecimal total = BigDecimal.ZERO;
        for (BankAccount account : accounts) {
            // This is where the magic happens: recursive call!
            // If account is a leaf, returns its balance directly
            // If account is another composite, recursively sums its children
            total = total.add(account.getBalance());
        }
        Logger.debug("Calculated total balance for {0}: ${1}", accountName, total);
        return total;
    }

    /**
     * Displays this joint account and all its children recursively.
     * <p>
     * This is the core recursive display method for composites.
     *
     * <p>Algorithm:
     * <ol>
     *   <li>Display this composite account with its total</li>
     *   <li>For each child account, call display() with increased indentation</li>
     * </ol>
     *
     * <p>Uses 👥 emoji for visual distinction from individual accounts.
     *
     * @param indent the indentation string for hierarchy display
     */
    @Override
    public void display(String indent) {
        Logger.log("{0}👥 {1} [Total: ${2}]", indent, accountName, getBalance());

        // Recursively display all child accounts with increased indentation
        // This creates the visual tree structure in the output
        for (BankAccount account : accounts) {
            account.display(indent + "  ");
        }
    }

    /**
     * Adds a child account to this joint account.
     * <p>
     * This is the key composite operation that enables hierarchy building.
     *
     * @param account the account to add (can be individual or another joint account)
     */
    public void addAccount(BankAccount account) {
        accounts.add(account);
        Logger.debug("Added account {0} to joint account {1}",
                account.getName(), accountName);
    }

    /**
     * Removes a child account from this joint account.
     *
     * @param account the account to remove
     * @return true if the account was removed, false if it wasn't found
     */
    public boolean removeAccount(BankAccount account) {
        boolean removed = accounts.remove(account);
        if (removed) {
            Logger.debug("Removed account {0} from joint account {1}",
                    account.getName(), accountName);
        } else {
            Logger.warn("Account {0} not found in joint account {1}",
                    account.getName(), accountName);
        }
        return removed;
    }

    /**
     * Returns a defensive copy of all child accounts.
     * <p>
     * Using defensive copy prevents external modification of internal list.
     *
     * @return a new list containing all child accounts
     */
    public List<BankAccount> getAccounts() {
        return new ArrayList<>(accounts); // Defensive copy
    }

    /**
     * Business method specific to joint accounts.
     * <p>
     * Distributes a bonus equally among all account holders.
     * Demonstrates composite-specific business logic.
     *
     * @param totalBonus the total bonus amount to distribute
     * @return the amount each account holder receives
     */
    public BigDecimal distributeBonus(BigDecimal totalBonus) {
        if (accounts.isEmpty()) {
            Logger.warn("Cannot distribute bonus - joint account {0} has no accounts",
                    accountName);
            return BigDecimal.ZERO;
        }

        // Divide bonus equally among all accounts
        BigDecimal perAccount = totalBonus.divide(
                BigDecimal.valueOf(accounts.size()), 2, RoundingMode.HALF_UP);

        Logger.log("Distributed ${0} bonus in {1}: ${2} per account",
                totalBonus, accountName, perAccount);
        return perAccount;
    }

    /**
     * Business method specific to joint accounts.
     * <p>
     * Returns the number of individual accounts in this joint account.
     * This counts IndividualAccount instances only, not nested JointAccounts.
     * Demonstrates recursive counting in composite structures.
     *
     * @return count of individual account holders
     */
    public int getAccountHolderCount() {
        int count = 0;
        for (BankAccount account : accounts) {
            if (account instanceof IndividualAccount) {
                count++;
            } else if (account instanceof JointAccount jointAccount) {
                // Recursively count individual accounts in nested joint accounts
                // This demonstrates depth-first traversal of composite structure
                count += jointAccount.getAccountHolderCount();
            }
        }
        Logger.debug("Account holder count for {0}: {1}", accountName, count);
        return count;
    }

    /**
     * Returns the number of direct child accounts.
     * <p>
     * Utility method for structural analysis.
     *
     * @return number of direct children
     */
    public int getChildCount() {
        return accounts.size();
    }

    /**
     * String representation for debugging.
     *
     * @return string representation of this joint account
     */
    @Override
    public String toString() {
        return "JointAccount{name='" + accountName + "', childCount=" + accounts.size() + "}";
    }
}