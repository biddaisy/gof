package com.github.biddaisy.gof.creational.singleton.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Universal singleton registry.
 * Stores any singleton instance by name.
 */
public final class SingletonRegistry {

    private static final Map<String, Object> REGISTRY = new ConcurrentHashMap<>();

    static {
        loadAll();
    }

    private SingletonRegistry() {}

    public static void register(SingletonProvider<?> provider) {
        String name = provider.name();
        Object instance = provider.instance();

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Singleton name must not be null or blank");
        }
        if (instance == null) {
            throw new IllegalStateException("Singleton instance for '" + name + "' must not be null");
        }

        REGISTRY.put(name, instance);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String name) {
        Object instance = REGISTRY.get(name);

        if (instance == null) {
            throw new IllegalStateException("No singleton registered with name: " + name);
        }

        return (T) instance;
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String name, Class<T> type) {
        Object instance = REGISTRY.get(name);

        if (instance == null) {
            throw new IllegalStateException("No singleton registered with name: " + name);
        }
        if (!type.isInstance(instance)) {
            throw new ClassCastException(
                    "Singleton '" + name + "' is not of type " + type.getName()
                            + " but " + instance.getClass().getName());
        }

        return (T) instance;
    }

    private static void loadAll() {
        for (SingletonProvider<?> provider : SingletonIndex.ALL) {
            register(provider);
        }
    }
}
