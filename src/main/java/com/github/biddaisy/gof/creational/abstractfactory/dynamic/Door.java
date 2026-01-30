package com.github.biddaisy.gof.creational.abstractfactory.dynamic;

/**
 * Door connecting two rooms.
 * In Smalltalk: (factory make: #door) from: room1 to: room2.
 */
public class Door extends MapSite {

    private Room room1;
    private Room room2;

    /**
     * Fluent method to match Smalltalk's "from:to:" message.
     */
    public Door from(Room r1, Room r2) {
        this.room1 = r1;
        this.room2 = r2;
        return this;
    }

    @Override
    public void enter() {}
}
