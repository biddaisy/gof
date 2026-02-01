package com.github.biddaisy.gof.creational.singleton.serialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.github.biddaisy.gof.Logger.error;
import static com.github.biddaisy.gof.Logger.log;

public class Demo {

    public static final String SINGLETON_OBJ = "singleton.obj";

    public static void main(String[] args) throws Exception {

        SerializationSafeSingleton s1 = SerializationSafeSingleton.getInstance();

        // Serialize
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SINGLETON_OBJ))){
            out.writeObject(s1);
        }

        // Deserialize
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(SINGLETON_OBJ))) {
            SerializationSafeSingleton s2 = (SerializationSafeSingleton) in.readObject();
            log("s1 == s2: " + (s1 == s2)); // true
        }

        // Clean up using java.nio.file.Files for proper diagnostics
        try {
            Files.deleteIfExists(Path.of(SINGLETON_OBJ));
        } catch (IOException e) {
            error("Failed to delete test file: " + SINGLETON_OBJ, e);
        }
    }
}
