package com.github.biddaisy.gof.creational.singleton.statickblock;

import static com.github.biddaisy.gof.Logger.log;

/**
 * Thread-safe Singleton using a static initialization block.
 *
 * Allows handling exceptions during initialization.
 */
public class StaticBlockSingleton {

    private static final StaticBlockSingleton INSTANCE;

    static {
        INSTANCE = new StaticBlockSingleton();
    }

    private StaticBlockSingleton() {}

    public static StaticBlockSingleton getInstance() {
        return INSTANCE;
    }

    public void doWork() {
        log("StaticBlockSingleton working...");
    }
}
