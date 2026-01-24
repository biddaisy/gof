package com.mr.gof.creational.abstractfactory.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Maze container that holds rooms.
 */
public class Maze {

    private final List<Room> rooms = new ArrayList<>();

    public Maze addRoom(Room room) {
        rooms.add(room);
        return this;
    }

    /**
     * Public read‑only access to rooms.
     */
    public List<Room> getRooms() {
        return Collections.unmodifiableList(rooms);
    }
}
