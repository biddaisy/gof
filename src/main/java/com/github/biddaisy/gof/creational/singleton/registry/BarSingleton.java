package com.github.biddaisy.gof.creational.singleton.registry;

import static com.github.biddaisy.gof.Logger.log;

public final class BarSingleton {

    private static final BarSingleton INSTANCE = new BarSingleton();

    public static class Provider implements SingletonProvider<BarSingleton> {
        @Override
        public String name() {
            return "Bar";
        }

        @Override
        public BarSingleton instance() {
            return INSTANCE;
        }
    }

    private BarSingleton() {}

    public void doWork() {
        log("BarSingleton working...");
    }
}
