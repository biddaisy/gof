package com.mr.gof.creational.abstractfactory.classic;

public class RoomWithABomb extends Room {

    private boolean exploded = false;

    public RoomWithABomb(int n) {
        super(n);
    }

    public void explode() {
        this.exploded = true;
    }

    public boolean isBombPresent() {
        return true;
    }

    public boolean isExploded() {
        return exploded;
    }
}
