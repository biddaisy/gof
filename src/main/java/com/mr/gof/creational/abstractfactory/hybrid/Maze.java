package com.mr.gof.creational.abstractfactory.hybrid;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    private final List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
