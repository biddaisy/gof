package com.github.biddaisy.gof.creational.abstractfactory.classic;

public class Demo {

    public static void main(String[] args) {

        MazeGame game = new MazeGame();

        // ---------------------------------------------------------
        // Standard Maze
        // ---------------------------------------------------------
        MazeFactory standardFactory = new MazeFactory();
        Maze standardMaze = game.createMaze(standardFactory);
        MazePrinter.printMaze("Standard Maze", standardMaze);

        // ---------------------------------------------------------
        // Enchanted Maze
        // ---------------------------------------------------------
        MazeFactory enchantedFactory = new EnchantedMazeFactory();
        Maze enchantedMaze = game.createMaze(enchantedFactory);
        MazePrinter.printMaze("Enchanted Maze", enchantedMaze);

        // ---------------------------------------------------------
        // Bombed Maze
        // ---------------------------------------------------------
        MazeFactory bombedFactory = new BombedMazeFactory();
        Maze bombedMaze = game.createMaze(bombedFactory);
        MazePrinter.printMaze("Bombed Maze", bombedMaze);
    }
}
