package com.mr.gof.creational.abstractfactory.dynamic;

/**
 * Demonstrates the hybrid MazeBuilder + AbstractFactory pattern.
 */
public class HybridDemo {

    public static void main(String[] args) {

        MazeGame game = new MazeGame();

        // ---------------------------------------------------------
        // Standard Maze
        // ---------------------------------------------------------
        System.out.println("=== Standard Maze (Builder + Factory) ===");

        MazeFactory standardFactory =
                StandardMazeFactoryCreator.createMazeFactory();

        MazeBuilder standardBuilder =
                new StandardMazeBuilder(standardFactory);

        Maze standardMaze = game.createMaze(standardBuilder);

        DemoUtils.printMaze("Standard Maze", standardMaze);


        // ---------------------------------------------------------
        // Enchanted Maze
        // ---------------------------------------------------------
        System.out.println("\n=== Enchanted Maze (Builder + Factory) ===");

        MazeFactory enchantedFactory =
                EnchantedMazeFactoryCreator.createMazeFactory();

        MazeBuilder enchantedBuilder =
                new StandardMazeBuilder(enchantedFactory);

        Maze enchantedMaze = game.createMaze(enchantedBuilder);

        DemoUtils.printMaze("Enchanted Maze", enchantedMaze);
    }
}
