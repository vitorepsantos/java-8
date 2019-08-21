package br.code.maze;

import br.code.maze.pojo.Door;
import br.code.maze.pojo.Maze;
import br.code.maze.pojo.Room;
import br.code.maze.pojo.Wall;

public interface MazeFactory {

    Maze makeMaze();

    Wall makeWall();

    Room makeRoom(int i);

    Door makeDoor(Room a, Room b);

}
