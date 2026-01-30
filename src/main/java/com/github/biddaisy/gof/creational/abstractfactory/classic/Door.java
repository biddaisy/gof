package com.github.biddaisy.gof.creational.abstractfactory.classic;

public class Door extends MapSite {

    protected Room room1;
    protected Room room2;

    public Door(Room r1, Room r2) {
        this.room1 = r1;
        this.room2 = r2;
    }

    @Override
    public void enter() {}
}
