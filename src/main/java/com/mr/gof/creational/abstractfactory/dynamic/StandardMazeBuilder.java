package com.mr.gof.creational.abstractfactory.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Concrete builder that uses a MazeFactory to create components.
 * This is the hybrid: Builder + AbstractFactory.
 */
public class StandardMazeBuilder implements MazeBuilder {

    private final MazeFactory factory;
    private Maze currentMaze;
    private final Map<Integer, Room> rooms = new HashMap<>();

    public StandardMazeBuilder(MazeFactory factory) {
        this.factory = factory;
    }

    @Override
    public void buildMaze() {
        currentMaze = new Maze();
    }

    @Override
    public void buildRoom(int roomNumber) {
        if (rooms.containsKey(roomNumber)) return;

        Room room = ((Room) factory.make("room")).number(roomNumber);

        // Default walls
        room.setSide(Direction.NORTH, factory.make("wall"));
        room.setSide(Direction.EAST,  factory.make("wall"));
        room.setSide(Direction.SOUTH, factory.make("wall"));
        room.setSide(Direction.WEST,  factory.make("wall"));

        rooms.put(roomNumber, room);
        currentMaze.addRoom(room);
    }

    @Override
    public void buildDoor(int room1, int room2) {
        Room r1 = rooms.get(room1);
        Room r2 = rooms.get(room2);

        Door door = ((Door) factory.make("door")).from(r1, r2);

        // For simplicity, connect EAST/WEST
        r1.setSide(Direction.EAST, door);
        r2.setSide(Direction.WEST, door);
    }

    @Override
    public Maze getMaze() {
        return currentMaze;
    }
}
