package com.github.biddaisy.gof.creational.singleton.registry;

import static com.github.biddaisy.gof.Logger.log;

public final class FooSingleton {

    private static final FooSingleton INSTANCE = new FooSingleton();

    public static class Provider implements SingletonProvider<FooSingleton> {
        @Override
        public String name() {
            return "Foo";
        }

        @Override
        public FooSingleton instance() {
            return INSTANCE;
        }
    }

    private FooSingleton() {}

    public void doWork() {
        log("FooSingleton working...");
    }
}
