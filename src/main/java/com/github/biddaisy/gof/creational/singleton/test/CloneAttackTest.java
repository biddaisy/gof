package com.github.biddaisy.gof.creational.singleton.test;

import com.github.biddaisy.gof.creational.singleton.serialization.SerializationSafeSingleton;

import java.lang.reflect.Method;

import static com.github.biddaisy.gof.Logger.error;
import static com.github.biddaisy.gof.Logger.log;

/**
 * Tests that cloning cannot break the Singleton.
 *
 * Since clone() is protected, we must use reflection to access it.
 */
public class CloneAttackTest {

    static void main(String[] args) throws Exception {

        log("=== Clone Attack Test ===");

        SerializationSafeSingleton original = SerializationSafeSingleton.getInstance();
        log("Original instance: " + original);

        try {
            // Access protected clone() via reflection
            Method cloneMethod = SerializationSafeSingleton.class.getDeclaredMethod("clone");
            cloneMethod.setAccessible(true);

            // Attempt to clone the Singleton
            SerializationSafeSingleton cloned =
                    (SerializationSafeSingleton) cloneMethod.invoke(original);

            // If we get here, cloning succeeded (BAD)
            error("ERROR: Cloning succeeded! Cloned instance: " + cloned);
            error("Singleton broken by cloning!");

        } catch (Exception e) {
            Throwable cause = e.getCause();

            if (cause instanceof CloneNotSupportedException) {
                log("Clone attack prevented: " + cause.getMessage());
                log("SUCCESS: Singleton resisted cloning.");
            } else {
                error("Unexpected exception during clone attack: " + e);
            }
        }
    }
}
