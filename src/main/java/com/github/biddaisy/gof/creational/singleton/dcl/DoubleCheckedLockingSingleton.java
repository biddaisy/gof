package com.github.biddaisy.gof.creational.singleton.dcl;

import static com.github.biddaisy.gof.Logger.log;

/**
 * Thread-safe Singleton using double-checked locking.
 *
 * Requires 'volatile' to prevent instruction reordering.
 */
public class DoubleCheckedLockingSingleton {

    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {}

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) { // First check
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) { // Second check
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    public void doWork() {
        log("DoubleCheckedLockingSingleton working...");
    }
}

