package com.mr.gof.creational.abstractfactory.hybrid;

import java.util.EnumMap;
import java.util.Map;

public class Room extends MapSite {

    private final int roomNumber;
    private final Map<Direction, MapSite> sides = new EnumMap<>(Direction.class);

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setSide(Direction dir, MapSite site) {
        sides.put(dir, site);
    }

    public MapSite getSide(Direction dir) {
        return sides.get(dir);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public void enter() {}
}
