package com.github.biddaisy.gof.creational.abstractfactory.dynamic;

/**
 * Enchanted factory that registers enchanted components.
 */
public class EnchantedMazeFactoryCreator {

    public static MazeFactory createMazeFactory() {
        return new MazeFactory()
                .addPart(Wall.class, "wall")
                .addPart(EnchantedRoom.class, "room")
                .addPart(DoorNeedingSpell.class, "door");
    }
}
