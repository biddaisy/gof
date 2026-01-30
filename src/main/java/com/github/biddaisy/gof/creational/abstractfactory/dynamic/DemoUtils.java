package com.github.biddaisy.gof.creational.abstractfactory.dynamic;

import com.github.biddaisy.gof.Logger;

public class DemoUtils {

    private DemoUtils() {
    }

    public static void printMaze(String title, Maze maze) {
        Logger.log("\n--- " + title + " ---");

        for (Room room : maze.getRooms()) {
            Logger.log("\nRoom " + room.getRoomNumber());
            for (Direction dir : Direction.values()) {
                MapSite side = room.getSide(dir);
                System.out.printf("  %-6s -> %s%n",
                        dir,
                        side.getClass().getSimpleName());
            }
        }
    }
}
