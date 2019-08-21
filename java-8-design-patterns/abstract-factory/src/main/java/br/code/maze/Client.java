package br.code.maze;

import br.code.maze.pojo.Maze;
import br.code.maze.pojo.bombed.BombedMazeFactory;
import br.code.maze.pojo.enchanted.EnchantedMazeFactory;

public class Client {
    public static void main(String[] args) {
        MazeGame mazeGame = new MazeGame();

        EnchantedMazeFactory enchantedMazeFactory = new EnchantedMazeFactory();

        Maze mazeEnchanted = mazeGame.createMaze(enchantedMazeFactory);

        BombedMazeFactory bombedMazeFactory = new BombedMazeFactory();

        Maze mazeBombed = mazeGame.createMaze(bombedMazeFactory);
        System.out.println("Maze Done!");
    }
}
