package com.github.biddaisy.gof.creational.abstractfactory.hybrid;

public class HybridDemo {

    public static void main(String[] args) {

        MazeGame game = new MazeGame();

        // Standard Maze
        MazeFactory standardFactory = new MazeFactory();
        MazeBuilder standardBuilder = new StandardMazeBuilder(standardFactory);
        Maze standardMaze = game.createMaze(standardBuilder);
        DemoUtils.printMaze("Standard Maze", standardMaze);

        // Enchanted Maze
        MazeFactory enchantedFactory = new EnchantedMazeFactory();
        MazeBuilder enchantedBuilder = new StandardMazeBuilder(enchantedFactory);
        Maze enchantedMaze = game.createMaze(enchantedBuilder);
        DemoUtils.printMaze("Enchanted Maze", enchantedMaze);

        // Bombed Maze
        MazeFactory bombedFactory = new BombedMazeFactory();
        MazeBuilder bombedBuilder = new StandardMazeBuilder(bombedFactory);
        Maze bombedMaze = game.createMaze(bombedBuilder);
        DemoUtils.printMaze("Bombed Maze", bombedMaze);
    }
}
