package com.mr.gof.structural.composite.bank;

import java.math.BigDecimal;

/**
 * Component Interface in the Composite Pattern.
 * <p>
 * Defines the common operations that all bank account types must implement.
 * This interface enables the Composite Pattern's key principle:
 * "Treat individual objects and compositions uniformly."
 *
 * <p>This interface represents the Component role in the Composite Pattern:
 * <ul>
 *   <li>Declares common operations for all objects in the composition</li>
 *   <li>May provide default implementations for some operations</li>
 *   <li>Enables recursive composition through the display() method</li>
 * </ul>
 *
 * <p>Key principles demonstrated:
 * <ul>
 *   <li>Common interface for leaf and composite objects</li>
 *   <li>Ability to treat individual and group accounts identically</li>
 *   <li>Recursive operations like balance calculation</li>
 *   <li>Hierarchical display through the indent parameter</li>
 * </ul>
 *
 * <p>All implementing classes (both leaf and composite) must provide
 * implementations for these three methods, ensuring uniform treatment.
 */
public interface BankAccount {

    /**
     * Returns the name of the account or account group.
     * <p>
     * This method demonstrates the uniform interface principle -
     * both leaf and composite objects can be asked for their name.
     *
     * @return the account name, formatted appropriately for the account type
     */
    String getName();

    /**
     * Calculates the total balance of the account.
     * <p>
     * This method demonstrates recursive operations in the Composite Pattern:
     * <ul>
     *   <li>For leaf accounts: returns the account's actual balance</li>
     *   <li>For composite accounts: recursively sums all child account balances</li>
     * </ul>
     *
     * <p>Uses BigDecimal for financial precision to avoid rounding errors.
     *
     * @return the total balance as BigDecimal for maximum precision
     */
    BigDecimal getBalance();

    /**
     * Displays the account hierarchy with proper indentation.
     * <p>
     * This method demonstrates the recursive nature of the Composite Pattern:
     * <ul>
     *   <li>For leaf accounts: displays the account information</li>
     *   <li>For composite accounts: displays the composite, then recursively
     *       displays all children with increased indentation</li>
     * </ul>
     *
     * <p>The indent parameter creates visual hierarchy in the output.
     *
     * @param indent the current indentation level for visual hierarchy display
     */
    void display(String indent);
}