package com.github.biddaisy.gof.creational.singleton.registry;

import static com.github.biddaisy.gof.Logger.log;

public final class LazyFooSingleton {

    private static volatile LazyFooSingleton INSTANCE;

    public static class Provider implements SingletonProvider<LazyFooSingleton> {
        @Override
        public String name() {
            return "LazyFoo";
        }

        @Override
        public LazyFooSingleton instance() {
            return getInstance();
        }
    }

    private LazyFooSingleton() {}

    public static LazyFooSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (LazyFooSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyFooSingleton();
                }
            }
        }
        return INSTANCE;
    }

    public void doWork() {
        log("LazyFooSingleton working...");
    }
}
