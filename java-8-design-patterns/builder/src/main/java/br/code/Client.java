package br.code;

import br.code.maze.Maze;
import br.code.maze.MazeBuilderCounting;
import br.code.maze.MazeGame;
import br.code.maze.MazeBuilderDefault;

public class Client
{
    public static void main( String[] args ) {
        MazeGame game = new MazeGame();
        MazeBuilderDefault builder = new MazeBuilderDefault();
        Maze maze = game.createMaze(builder); /** inject the concrete builder into the director **/
        System.out.println(maze.roomNo(1).getId());

        MazeGame game1 = new MazeGame();
        MazeBuilderCounting mazeBuilderCounting = new MazeBuilderCounting();
        Maze maze1 = game1.createMaze(mazeBuilderCounting); /** inject the concrete builder into the director **/
        int counts = mazeBuilderCounting.getCounts();
        System.out.println(counts);
    }
}
