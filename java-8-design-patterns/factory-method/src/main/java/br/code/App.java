package br.code;

import br.code.maze.BombedMazeGame;
import br.code.maze.EnchantedMazeGame;
import br.code.maze.Maze;
import br.code.maze.MazeGame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MazeGame mazeGame = new MazeGame();
        Maze mazeDefault = mazeGame.createMaze();

        mazeGame = new BombedMazeGame();
        Maze bombedMaze = mazeGame.createMaze();

        mazeGame = new EnchantedMazeGame();
        Maze enchantedMaze = mazeGame.createMaze();

    }
}
