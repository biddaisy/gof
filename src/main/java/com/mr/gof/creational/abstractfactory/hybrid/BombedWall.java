package com.mr.gof.creational.abstractfactory.hybrid;

public class BombedWall extends Wall {

    private boolean damaged = false;

    public void damage() {
        damaged = true;
    }

    public boolean isDamaged() {
        return damaged;
    }
}
