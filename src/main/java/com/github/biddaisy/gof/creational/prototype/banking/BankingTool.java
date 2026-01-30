package com.github.biddaisy.gof.creational.prototype.banking;

/**
 * Framework tool that creates new banking products by cloning a prototype.
 *
 * This mirrors the GoF GraphicTool:
 *   - The tool is parameterized by a prototype instance.
 *   - Each action clones the prototype and inserts it into the document.
 */
public class BankingTool extends Tool {

    private final BankingProduct prototype;

    public BankingTool(BankingProduct prototype) {
        this.prototype = prototype;
    }

    @Override
    public void onAction(BankingDocument document) {
        BankingProduct newProduct = prototype.cloneProduct();
        document.addProduct(newProduct);
    }
}
