package com.github.biddaisy.gof.creational.abstractfactory.classic;

public class MazePrinter {

    public static void printMaze(String title, Maze maze) {
        System.out.println("\n=== " + title + " ===");

        for (Room room : maze.getRooms()) {
            System.out.println("\nRoom " + room.getRoomNumber());

            for (Direction dir : Direction.values()) {
                MapSite side = room.getSide(dir);
                String type = (side == null)
                        ? "null"
                        : side.getClass().getSimpleName();

                System.out.printf("  %-6s -> %s%n", dir, type);
            }
        }
    }
}
