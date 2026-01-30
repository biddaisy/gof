package com.github.biddaisy.gof.creational.abstractfactory.hybrid;

public class DemoUtils {

    public static void printMaze(String title, Maze maze) {
        System.out.println("\n--- " + title + " ---");

        for (Room room : maze.getRooms()) {
            System.out.println("\nRoom " + room.getRoomNumber());
            for (Direction dir : Direction.values()) {
                MapSite side = room.getSide(dir);
                System.out.printf("  %-6s -> %s%n",
                        dir,
                        side.getClass().getSimpleName());
            }
        }
    }
}
