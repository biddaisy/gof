package com.github.biddaisy.gof.creational.abstractfactory.dynamic;

/**
 * Creates a standard MazeFactory with default components.
 */
public class StandardMazeFactoryCreator {

    public static MazeFactory createMazeFactory() {
        return new MazeFactory()
                .addPart(Wall.class, "wall")
                .addPart(Room.class, "room")
                .addPart(Door.class, "door");
    }
}
