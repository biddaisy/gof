package com.github.biddaisy.gof.creational.abstractfactory.dynamic;

/**
 * Builder interface for constructing mazes step-by-step.
 * Works together with MazeFactory to create components.
 */
public interface MazeBuilder {

    void buildMaze();
    void buildRoom(int roomNumber);
    void buildDoor(int room1, int room2);

    Maze getMaze();
}
