package com.mr.gof.creational.abstractfactory.dynamic;

import java.util.EnumMap;
import java.util.Map;

/**
 * Represents a room in the maze.
 */
public class Room extends MapSite {

    private int roomNumber;
    private final Map<Direction, MapSite> sides = new EnumMap<>(Direction.class);

    public Room() {}

    public Room number(int n) {
        this.roomNumber = n;
        return this;
    }

    public void setSide(Direction dir, MapSite site) {
        sides.put(dir, site);
    }

    /**
     * Public getter for room number.
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Public getter for a side.
     */
    public MapSite getSide(Direction dir) {
        return sides.get(dir);
    }

    @Override
    public void enter() {}
}
