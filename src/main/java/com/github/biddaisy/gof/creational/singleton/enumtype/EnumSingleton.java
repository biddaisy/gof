package com.github.biddaisy.gof.creational.singleton.enumtype;

import static com.github.biddaisy.gof.Logger.log;

/**
 * Enum-based Singleton.
 *
 * Thread-safe, serialization-safe, and reflection-proof.
 */
public enum EnumSingleton {
    INSTANCE;

    public void doWork() {
        log("EnumSingleton working...");
    }
}

