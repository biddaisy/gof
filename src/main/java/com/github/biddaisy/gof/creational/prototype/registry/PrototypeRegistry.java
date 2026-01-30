package com.github.biddaisy.gof.creational.prototype.registry;

import java.util.HashMap;
import java.util.Map;

/**
 * Prototype Registry.
 *
 * This is the "super-powerful" version of the Prototype pattern.
 *
 * - Stores prototypes under string keys.
 * - Allows dynamic registration of new prototypes at runtime.
 * - Allows lookup and cloning by name.
 * - Decouples creation logic from concrete classes.
 *
 * This is extremely flexible and ideal for plugin systems.
 */
public class PrototypeRegistry {

    private final Map<String, BankingProduct> registry = new HashMap<>();

    /**
     * Registers a prototype under a given key.
     */
    public void registerPrototype(String key, BankingProduct prototype) {
        registry.put(key, prototype);
    }

    /**
     * Creates a new product by cloning the prototype associated with the key.
     */
    public BankingProduct create(String key) {
        BankingProduct prototype = registry.get(key);
        if (prototype == null) {
            throw new IllegalArgumentException("No prototype registered for key: " + key);
        }
        return prototype.cloneProduct();
    }
}
