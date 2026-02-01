package com.github.biddaisy.gof.creational.singleton.registry;

/**
 * Universal contract for any singleton to participate in the registry.
 */
public interface SingletonProvider<T> {
    String name();
    T instance();
}
