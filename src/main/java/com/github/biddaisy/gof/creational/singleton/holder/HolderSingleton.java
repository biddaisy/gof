package com.github.biddaisy.gof.creational.singleton.holder;

import static com.github.biddaisy.gof.Logger.log;

/**
 * Best-practice Singleton using the Initialization-on-Demand Holder idiom.
 *
 * Thread-safe, lazy, and fast with no synchronization.
 */
public class HolderSingleton {

    private HolderSingleton() {}

    private static class Holder {
        private static final HolderSingleton INSTANCE = new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return Holder.INSTANCE;
    }

    public void doWork() {
        log("HolderSingleton working...");
    }
}

