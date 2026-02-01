package com.github.biddaisy.gof.creational.singleton.eager;

import static com.github.biddaisy.gof.Logger.log;

/**
 * Thread-safe Singleton using eager initialization.
 *
 * The instance is created when the class is loaded.
 * Class loading in Java is guaranteed to be thread-safe.
 */
public class EagerSingleton {

    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

    public void doWork() {
        log("EagerSingleton working...");
    }
}
