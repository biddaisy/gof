package com.github.biddaisy.gof.creational.singleton.registry;

/**
 * Central index of all singleton providers.
 * This is the only place where singletons are declared.
 */
public final class SingletonIndex {

    private SingletonIndex() {}

    static final SingletonProvider<?>[] ALL = {
            new FooSingleton.Provider(),
            new BarSingleton.Provider(),
            new LazyFooSingleton.Provider()
    };
}
