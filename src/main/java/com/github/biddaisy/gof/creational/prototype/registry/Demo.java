package com.github.biddaisy.gof.creational.prototype.registry;

import static com.github.biddaisy.gof.Logger.log;

/**
 * Demonstrates the Prototype Registry pattern.
 *
 * The registry stores prototypes under string keys.
 * Tools request clones by key.
 */
public class Demo {

    public static void main(String[] args) {

        BankingDocument portfolio = new BankingDocument();
        PrototypeRegistry registry = new PrototypeRegistry();

        // === REGISTER PROTOTYPES ===
        registry.registerPrototype("savings", new BankAccount("Savings", 1.5));
        registry.registerPrototype("mortgage", new Loan("Mortgage", 3.2));
        registry.registerPrototype("credit", new Card("Credit", 5000));

        // === TOOLS USING REGISTRY KEYS ===
        Tool savingsTool = new RegistryTool(registry, "savings");
        Tool mortgageTool = new RegistryTool(registry, "mortgage");
        Tool creditTool = new RegistryTool(registry, "credit");

        // === USER ACTIONS ===
        savingsTool.onAction(portfolio);
        mortgageTool.onAction(portfolio);
        creditTool.onAction(portfolio);

        // Add another savings account
        savingsTool.onAction(portfolio);

        log("Products:");

        portfolio.getProducts().forEach(BankingProduct::display);
    }
}
