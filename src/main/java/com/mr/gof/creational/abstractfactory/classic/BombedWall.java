package com.mr.gof.creational.abstractfactory.classic;

public class BombedWall extends Wall {

    private boolean damaged;

    public void damage() {
        damaged = true;
    }
}
