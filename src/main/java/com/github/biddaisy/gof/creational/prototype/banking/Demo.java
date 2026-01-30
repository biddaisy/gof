package com.github.biddaisy.gof.creational.prototype.banking;

/**
 * Demonstrates the Prototype pattern in a banking domain.
 *
 * Each tool is configured with a prototype.
 * Triggering the tool clones the prototype and adds it to the document.
 */
public class Demo {

    public static void main(String[] args) {

        BankingDocument portfolio = new BankingDocument();

        // === PROTOTYPES ===
        BankingProduct savingsPrototype = new BankAccount("Savings", 1.5);
        BankingProduct mortgagePrototype = new Loan("Mortgage", 3.2);
        BankingProduct creditCardPrototype = new Card("Credit", 5000);

        // === TOOLS CONFIGURED WITH PROTOTYPES ===
        Tool savingsTool = new BankingTool(savingsPrototype);
        Tool mortgageTool = new BankingTool(mortgagePrototype);
        Tool creditCardTool = new BankingTool(creditCardPrototype);

        // === USER ACTIONS ===
        savingsTool.onAction(portfolio);
        mortgageTool.onAction(portfolio);
        creditCardTool.onAction(portfolio);

        // Add another savings account
        savingsTool.onAction(portfolio);
    }
}
