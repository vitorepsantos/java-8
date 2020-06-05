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
        game.createMaze(builder);
        Maze maze = builder.getMaze();
        System.out.println(maze.roomNo(1).getId());

        MazeGame game1 = new MazeGame();
        MazeBuilderCounting mazeBuilderCounting = new MazeBuilderCounting();
        game1.createMaze(mazeBuilderCounting);
        int counts = mazeBuilderCounting.getCounts();
        System.out.println(counts);
    }
}
