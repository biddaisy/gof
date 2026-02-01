package com.github.biddaisy.gof.creational.singleton.test;

import com.github.biddaisy.gof.creational.singleton.serialization.SerializationSafeSingleton;

import java.lang.reflect.Constructor;

import static com.github.biddaisy.gof.Logger.error;
import static com.github.biddaisy.gof.Logger.log;

/**
 * Attempts to break the Singleton using reflection.
 *
 * This test demonstrates that:
 *   - Class-based Singletons are vulnerable to reflection
 *   - Enum Singletons are immune
 *
 * Expected result:
 *   - Two different instances (reflection breaks the Singleton)
 */
public class ReflectionAttackTest {

    static void main(String[] args) throws Exception {

        log("=== Reflection Attack Test ===");

        SerializationSafeSingleton s1 = SerializationSafeSingleton.getInstance();
        log("Original instance: " + s1);

        // Attempt to break Singleton using reflection
        Constructor<SerializationSafeSingleton> ctor =
                SerializationSafeSingleton.class.getDeclaredConstructor();

        ctor.setAccessible(true); // bypass private constructor

        SerializationSafeSingleton s2 = ctor.newInstance();
        log("Reflection-created instance: " + s2);

        boolean same = (s1 == s2);

        log("\nSingleton preserved: " + same);

        if (!same) {
            error("WARNING: Reflection successfully broke the Singleton!");
        } else {
            log("SUCCESS: Singleton resisted reflection attack.");
        }
    }
}
