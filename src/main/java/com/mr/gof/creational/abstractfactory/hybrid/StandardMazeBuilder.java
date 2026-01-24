package com.mr.gof.creational.abstractfactory.hybrid;

import java.util.HashMap;
import java.util.Map;

public class StandardMazeBuilder implements MazeBuilder {

    private final MazeFactory factory;
    private Maze currentMaze;
    private final Map<Integer, Room> rooms = new HashMap<>();

    public StandardMazeBuilder(MazeFactory factory) {
        this.factory = factory;
    }

    @Override
    public void buildMaze() {
        currentMaze = factory.makeMaze();
    }

    @Override
    public void buildRoom(int roomNumber) {
        if (rooms.containsKey(roomNumber)) return;

        Room room = factory.makeRoom(roomNumber);

        room.setSide(Direction.NORTH, factory.makeWall());
        room.setSide(Direction.EAST,  factory.makeWall());
        room.setSide(Direction.SOUTH, factory.makeWall());
        room.setSide(Direction.WEST,  factory.makeWall());

        rooms.put(roomNumber, room);
        currentMaze.addRoom(room);
    }

    @Override
    public void buildDoor(int room1, int room2) {
        Room r1 = rooms.get(room1);
        Room r2 = rooms.get(room2);

        Door door = factory.makeDoor(r1, r2);

        r1.setSide(Direction.EAST, door);
        r2.setSide(Direction.WEST, door);
    }

    @Override
    public Maze getMaze() {
        return currentMaze;
    }
}
