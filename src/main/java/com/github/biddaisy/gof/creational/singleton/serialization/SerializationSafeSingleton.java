package com.github.biddaisy.gof.creational.singleton.serialization;

import java.io.ObjectStreamException;
import java.io.Serial;
import java.io.Serializable;

import static com.github.biddaisy.gof.Logger.error;
import static com.github.biddaisy.gof.Logger.log;

/**
 * Serialization-safe, reflection-safe, clone-safe Singleton using readResolve().
 */
public class SerializationSafeSingleton implements Serializable, Cloneable {

    @Serial
    private static final long serialVersionUID = 1L;

    // Eager initialization ensures thread safety
    private static final SerializationSafeSingleton INSTANCE = new SerializationSafeSingleton();

    /**
     * Guard flag initialized statically.
     * The constructor checks if INSTANCE is already constructed.
     */
    private static boolean constructed = false;

    private SerializationSafeSingleton() {
        if (constructed) {
            error("Reflection attack detected: second instance creation attempt blocked.");
            throw new IllegalStateException("Singleton instance already created");
        }
        constructed = true;
    }

    public static SerializationSafeSingleton getInstance() {
        return INSTANCE;
    }

    public void doWork() {
        log("SerializationSafeSingleton working...");
    }

    @Serial
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        error("Clone attack detected: clone() is not allowed on Singleton.");
        throw new CloneNotSupportedException("Cloning of Singleton is not allowed");
    }
}
