package com.github.biddaisy.gof.creational.singleton.synchronizedmethod;

import static com.github.biddaisy.gof.Logger.log;

/**
 * Thread-safe Singleton using synchronized accessor.
 *
 * Simple but slow due to synchronization on every call.
 */
public class SynchronizedSingleton {

    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {}

    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }

    public void doWork() {
        log("SynchronizedSingleton working...");
    }
}

