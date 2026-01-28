package com.mr.gof.structural.composite.bank;

import com.mr.gof.Logger;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstration class showing the Composite Pattern in action with custom logging.
 * <p>
 * This class demonstrates:
 * <ol>
 *   <li>Creating a hierarchy of bank accounts at multiple levels</li>
 *   <li>Treating individual and composite accounts uniformly through the BankAccount interface</li>
 *   <li>Performing operations on the entire hierarchy with recursive algorithms</li>
 *   <li>The power of recursive composition for financial calculations</li>
 *   <li>How the Composite Pattern enables clean separation of concerns</li>
 *   <li>Real-world parameterized operations using the pattern</li>
 * </ol>
 *
 * <p>The demonstration shows:
 * <ul>
 *   <li>Leaf nodes: IndividualAccount objects</li>
 *   <li>Composite nodes: JointAccount and CustomerPortfolio objects</li>
 *   <li>Multiple hierarchy levels: Individual → Joint → Portfolio → Branch</li>
 *   <li>Uniform operations: getBalance(), display(), getName()</li>
 *   <li>Specialized operations at different hierarchy levels</li>
 * </ul>
 */
public class CompositeBankDemo {

    private CompositeBankDemo() {
    }

    /**
     * Main entry point for the Composite Pattern demonstration.
     *
     * @param args command line arguments (not used)
     */
    static void main(String[] args) {
        // 1. INTRODUCTION
        Logger.log("Bank Account Composite Pattern Demo");
        Logger.log("Demonstrating the Composite Pattern with parameterized domain");
        Logger.log("Key principle: Treat individual and composite accounts uniformly");

        // 2. ACCOUNT CREATION PHASE
        Logger.log("Account Creation Phase");

        // 2.1 Create individual accounts (Leaf nodes)
        Logger.log("Creating individual accounts (Leaf nodes)");
        Logger.debug("Leaf nodes cannot contain other accounts");

        IndividualAccount johnSavings = new IndividualAccount("John Doe",
                new BigDecimal("15000.50"));
        BankAccount johnChecking = new IndividualAccount("John Doe",
                new BigDecimal("3200.75"));
        BankAccount sarahAccount = new IndividualAccount("Sarah Smith",
                new BigDecimal("8500.25"));

        Logger.log("Created 3 individual accounts (leaf nodes)");

        // 2.2 Create joint account (Composite node with leaves)
        Logger.log("Creating joint account (Composite node)");
        Logger.debug("Composite nodes can contain both leaves and other composites");

        JointAccount familyAccount = new JointAccount("Family Savings");
        familyAccount.addAccount(new IndividualAccount("John Doe",
                new BigDecimal("5000.00")));
        familyAccount.addAccount(new IndividualAccount("Jane Doe",
                new BigDecimal("5000.00")));

        Logger.log("Created joint account: {0} with {1} holders",
                familyAccount.getName(), familyAccount.getAccountHolderCount());

        // 2.3 Create customer portfolios (Higher-level composites)
        Logger.log("Creating customer portfolios (Higher-level composites)");
        Logger.debug("Portfolios can contain both individual and joint accounts");

        CustomerPortfolio johnPortfolio = new CustomerPortfolio("John Doe");
        johnPortfolio.addAccount(johnSavings);
        johnPortfolio.addAccount(johnChecking);
        johnPortfolio.addAccount(familyAccount); // Composite within composite

        CustomerPortfolio sarahPortfolio = new CustomerPortfolio("Sarah Smith");
        sarahPortfolio.addAccount(sarahAccount);

        Logger.log("Created 2 customer portfolios");

        // 2.4 Create branch aggregation (Top-level composite)
        Logger.log("Creating branch-level aggregation (Top-level composite)");
        Logger.debug("Demonstrating multiple levels of composition");

        JointAccount downtownBranch = new JointAccount("Downtown Branch");
        downtownBranch.addAccount(johnPortfolio);
        downtownBranch.addAccount(sarahPortfolio);

        Logger.log("Created complete hierarchy with {0} levels of composition", 4);

        // 3. HIERARCHY DISPLAY
        Logger.log("Account Hierarchy Display");
        Logger.log("Demonstrating recursive display of the entire hierarchy:");
        Logger.log("Note the visual indentation showing parent-child relationships");

        downtownBranch.display("");

        // 4. FINANCIAL ANALYSIS
        Logger.log("Financial Analysis");
        Logger.log("Demonstrating recursive financial calculations:");

        // 4.1 Total assets (recursive sum)
        Logger.log("Total Branch Assets: ${0}", downtownBranch.getBalance());

        // 4.2 Individual portfolio totals
        Logger.log("John's Total Assets: ${0}", johnPortfolio.getBalance());
        Logger.log("Sarah's Total Assets: ${0}", sarahPortfolio.getBalance());

        // 4.3 Joint account details
        Logger.log("Family Account Total: ${0}", familyAccount.getBalance());
        Logger.log("Family Account Holders: {0}",
                familyAccount.getAccountHolderCount());

        // 4.4 Interest calculation
        BigDecimal johnInterest = johnPortfolio.getTotalAnnualInterest(3.0);
        Logger.log("John's Annual Interest (3%): ${0}", johnInterest);

        // 5. UNIFORM INTERFACE DEMONSTRATION
        Logger.log("Uniform Interface Demonstration");
        Logger.log("All account types implement the same BankAccount interface:");
        Logger.log("This enables polymorphic treatment of the entire hierarchy");

        List<BankAccount> diverseAccounts = Arrays.asList(
                johnSavings,      // Leaf: IndividualAccount
                familyAccount,    // Composite: JointAccount
                johnPortfolio     // Higher-level Composite: CustomerPortfolio
        );

        for (BankAccount account : diverseAccounts) {
            // Same method calls work on all account types!
            // This is the power of the Composite Pattern
            Logger.log("  {0} Balance: ${1}",
                    account.getName(), account.getBalance());
        }

        // 6. PORTFOLIO ANALYSIS
        Logger.log("Portfolio Analysis");
        Logger.log("Demonstrating composite-specific business logic:");

        johnPortfolio.getPortfolioSummary().printSummary();

        // 7. TRANSACTION PROCESSING
        Logger.log("Transaction Processing");
        Logger.log("Demonstrating business operations on leaf nodes:");

        try {
            BigDecimal newBalance = johnSavings.applyTransaction(
                    new BigDecimal("1000.00"));
            Logger.log("John deposited $1,000. New savings balance: ${0}",
                    newBalance);
        } catch (Exception e) {
            Logger.error("Transaction failed", e);
        }

        // 8. BONUS DISTRIBUTION
        Logger.log("Bonus Distribution");
        Logger.log("Demonstrating composite-specific business logic:");

        BigDecimal familyBonus = familyAccount.distributeBonus(new BigDecimal("500.00"));
        Logger.log("Family account bonus distribution: ${0} per holder", familyBonus);

        // 9. ERROR HANDLING DEMONSTRATION
        Logger.log("Error Handling Demonstration");
        Logger.log("Demonstrating robust error handling with logging:");

        try {
            // This should fail - attempting to withdraw more than balance
            Logger.debug("Attempting invalid withdrawal...");
            johnSavings.applyTransaction(new BigDecimal("-20000.00"));
        } catch (IllegalArgumentException e) {
            Logger.warn("Expected transaction failure: {0}", e.getMessage());
            Logger.log("Error handling works correctly!");
        }

        // 10. DEBUG INFORMATION
        Logger.log("Debug Information");
        Logger.log("Demonstrating debug-level logging:");

        Logger.debug("Branch account count: {0}",
                downtownBranch.getAccounts().size());
        Logger.debug("John's portfolio account count: {0}",
                johnPortfolio.getPortfolioSummary().getTotalAccountCount());
        Logger.debug("Hierarchy depth: 4 levels (Individual → Joint → Portfolio → Branch)");

        // 11. SUMMARY AND CONCLUSION
        Logger.log("Demo Summary");
        Logger.log("Composite Pattern demonstration completed successfully!");
        Logger.log("");
        Logger.log("Key takeaways:");
        Logger.log("1. Uniform interface enables treating leaves and composites identically");
        Logger.log("2. Recursive operations simplify complex hierarchy management");
        Logger.log("3. Easy to add new account types without modifying existing code");
        Logger.log("4. Hierarchical structures are naturally represented");
        Logger.log("5. Business logic can be applied at any level of the hierarchy");

        Logger.log("End of Demo");
    }
}