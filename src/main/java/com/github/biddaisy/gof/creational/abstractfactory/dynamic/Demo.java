package com.github.biddaisy.gof.creational.abstractfactory.dynamic;

import com.github.biddaisy.gof.Logger;

/**
 * Demonstrates the hybrid MazeBuilder + AbstractFactory pattern.
 */
public class Demo {

    public static void main(String[] args) {

        MazeGame game = new MazeGame();

        // ---------------------------------------------------------
        // Standard Maze
        // ---------------------------------------------------------
        Logger.log("=== Standard Maze (Builder + Factory) ===");

        MazeFactory standardFactory =
                StandardMazeFactoryCreator.createMazeFactory();

        MazeBuilder standardBuilder =
                new StandardMazeBuilder(standardFactory);

        Maze standardMaze = game.createMaze(standardBuilder);

        DemoUtils.printMaze("Standard Maze", standardMaze);


        // ---------------------------------------------------------
        // Enchanted Maze
        // ---------------------------------------------------------
        Logger.log("\n=== Enchanted Maze (Builder + Factory) ===");

        MazeFactory enchantedFactory =
                EnchantedMazeFactoryCreator.createMazeFactory();

        MazeBuilder enchantedBuilder =
                new StandardMazeBuilder(enchantedFactory);

        Maze enchantedMaze = game.createMaze(enchantedBuilder);

        DemoUtils.printMaze("Enchanted Maze", enchantedMaze);
    }
}
