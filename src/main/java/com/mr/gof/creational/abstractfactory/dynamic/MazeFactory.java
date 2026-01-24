package com.mr.gof.creational.abstractfactory.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic Abstract Factory.
 *
 * This is a direct Java translation of the Smalltalk version:
 *
 *   make: partName
 *       ^ (partCatalog at: partName) new
 *
 * The factory stores CLASS OBJECTS in a catalog and instantiates them on demand.
 */
public class MazeFactory {

    private final Map<String, Class<? extends MapSite>> partCatalog = new HashMap<>();

    /**
     * Registers a class under a symbolic name.
     * Equivalent to Smalltalk: addPart: Wall named: #wall.
     */
    public MazeFactory addPart(Class<? extends MapSite> clazz, String name) {
        partCatalog.put(name, clazz);
        return this;
    }

    /**
     * Creates a new instance of the class associated with partName.
     * This is the Java equivalent of "(partCatalog at: partName) new".
     */
    public MapSite make(String partName) {
        Class<? extends MapSite> clazz = partCatalog.get(partName);
        if (clazz == null) {
            throw new IllegalArgumentException("Unknown part: " + partName);
        }
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot instantiate: " + clazz, e);
        }
    }
}
