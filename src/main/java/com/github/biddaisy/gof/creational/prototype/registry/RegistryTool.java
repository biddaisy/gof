package com.github.biddaisy.gof.creational.prototype.registry;

/**
 * Tool that uses the PrototypeRegistry to create products.
 *
 * Instead of holding a prototype directly, it holds a registry key.
 * This allows:
 *   - dynamic switching of prototypes
 *   - dynamic addition of new product types
 *   - centralized prototype management
 */
public class RegistryTool extends Tool {

    private final PrototypeRegistry registry;
    private final String key;

    public RegistryTool(PrototypeRegistry registry, String key) {
        this.registry = registry;
        this.key = key;
    }

    @Override
    public void onAction(BankingDocument document) {
        BankingProduct product = registry.create(key);
        document.addProduct(product);
    }
}
