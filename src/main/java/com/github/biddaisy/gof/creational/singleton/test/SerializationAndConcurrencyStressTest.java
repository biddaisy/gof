package com.github.biddaisy.gof.creational.singleton.test;

import com.github.biddaisy.gof.creational.singleton.serialization.SerializationSafeSingleton;
import com.github.biddaisy.gof.creational.singleton.util.ExecutorServiceWrapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

import static com.github.biddaisy.gof.Logger.error;
import static com.github.biddaisy.gof.Logger.log;

/**
 * Combined stress test:
 * - Multithreaded Singleton access
 * - Serialization/deserialization cycles
 * - Identity consistency verification
 * <p>
 * Ensures:
 * - All threads receive the same instance
 * - Serialization does not create new instances
 * - ExecutorService is properly closed using try-with-resources (Java 25 style)
 * - Temporary files are deleted using java.nio.file.Files for proper diagnostics
 */
public class SerializationAndConcurrencyStressTest {

    private static final String FILE = "singleton_stress_test.bin";

    static void main(String[] args) throws Exception {

        log("=== Serialization + Multithread Stress Test ===");

        final int THREADS = 200;
        final int ITERATIONS = 5000;

        Set<SerializationSafeSingleton> instances =
                Collections.synchronizedSet(new HashSet<>());

        // Java 25–style try-with-resources using the wrapper
        try (ExecutorServiceWrapper wrapper =
                     new ExecutorServiceWrapper(
                             Executors.newFixedThreadPool(THREADS),
                             10,
                             TimeUnit.SECONDS)) {

            ExecutorService executor = wrapper.get();

            for (int i = 0; i < ITERATIONS; i++) {
                executor.submit(() -> {
                    SerializationSafeSingleton instance =
                            SerializationSafeSingleton.getInstance();
                    instances.add(instance);
                });
            }
        }

        log("Unique instances from threads: " + instances.size());

        // Serialize original instance
        SerializationSafeSingleton original = SerializationSafeSingleton.getInstance();
        serialize(original);

        // Deserialize multiple times
        Set<SerializationSafeSingleton> deserializedInstances = new HashSet<>();

        for (int i = 0; i < 50; i++) {
            deserializedInstances.add(deserialize());
        }

        log("Unique instances from deserialization: " + deserializedInstances.size());

        boolean threadSafe = (instances.size() == 1);
        boolean serializationSafe = (deserializedInstances.size() == 1);

        log("\nThread safety preserved: " + threadSafe);
        log("Serialization safety preserved: " + serializationSafe);

        if (threadSafe && serializationSafe) {
            log("\nSUCCESS: Singleton survived all stress tests.");
        } else {
            error("\nERROR: Singleton failed under stress.");
        }

        // Clean up using java.nio.file.Files for proper diagnostics
        try {
            Files.deleteIfExists(Path.of(FILE));
        } catch (IOException e) {
            error("Failed to delete test file: " + FILE, e);
        }
    }

    private static void serialize(SerializationSafeSingleton instance) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE))) {
            out.writeObject(instance);
        }
    }

    private static SerializationSafeSingleton deserialize()
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE))) {
            return (SerializationSafeSingleton) in.readObject();
        }
    }
}
