package com.github.biddaisy.gof.creational.abstractfactory.hybrid;

public interface MazeBuilder {

    void buildMaze();
    void buildRoom(int roomNumber);
    void buildDoor(int room1, int room2);

    Maze getMaze();
}
