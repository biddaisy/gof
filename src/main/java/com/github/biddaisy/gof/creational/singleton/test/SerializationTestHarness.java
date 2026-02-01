package com.github.biddaisy.gof.creational.singleton.test;

import com.github.biddaisy.gof.creational.singleton.serialization.SerializationSafeSingleton;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.github.biddaisy.gof.Logger.error;
import static com.github.biddaisy.gof.Logger.log;

/**
 * A full serialization test harness for verifying that a Singleton
 * remains a true Singleton across serialization boundaries.
 *
 * This test:
 *   1. Obtains the Singleton instance
 *   2. Serializes it to a file
 *   3. Deserializes it back
 *   4. Compares both references
 *   5. Prints detailed diagnostics
 *
 * Works with any Singleton that:
 *   - implements Serializable
 *   - implements readResolve() correctly
 */
public class SerializationTestHarness {

    private static final String FILE = "singleton_test.bin";

    static void main(String[] args) throws Exception {

        log("=== Serialization Test Harness ===");

        // Step 1: Get original instance
        SerializationSafeSingleton original = SerializationSafeSingleton.getInstance();
        log("Original instance: " + original);
        original.doWork();

        // Step 2: Serialize to file
        serialize(original);

        // Step 3: Deserialize from file
        SerializationSafeSingleton deserialized = deserialize();

        log("Deserialized instance: " + deserialized);
        deserialized.doWork();

        // Step 4: Identity check
        boolean same = (original == deserialized);
        log("\nSingleton preserved: " + same);

        if (!same) {
            error("ERROR: Singleton broken by serialization!");
        } else {
            log("SUCCESS: Singleton identity preserved.");
        }

        // Clean up using java.nio.file.Files for proper diagnostics
        try {
            Files.deleteIfExists(Path.of(FILE));
        } catch (IOException e) {
            error("Failed to delete test file: " + FILE, e);
        }
    }

    private static void serialize(SerializationSafeSingleton instance) throws IOException {
        log("\nSerializing instance to file: " + FILE);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE))) {
            out.writeObject(instance);
        }
    }

    private static SerializationSafeSingleton deserialize() throws IOException, ClassNotFoundException {
        log("Deserializing instance from file: " + FILE);
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE))) {
            return (SerializationSafeSingleton) in.readObject();
        }
    }
}
