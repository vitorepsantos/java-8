package br.code.maze;

import br.code.maze.pojo.Door;
import br.code.maze.pojo.Maze;
import br.code.maze.pojo.Room;
import br.code.maze.pojo.RoomSideDirection;

public class MazeGame {

    Maze createMaze(MazeFactory mazeFactory) {
        Maze maze = mazeFactory.makeMaze();
        Room r1 = mazeFactory.makeRoom(1);
        Room r2 = mazeFactory.makeRoom(2);
        Door door = mazeFactory.makeDoor(r1, r2);

        r1.setSide(RoomSideDirection.NORTH, mazeFactory.makeWall());
        r1.setSide(RoomSideDirection.EAST, door);
        r1.setSide(RoomSideDirection.SOUTH, mazeFactory.makeWall());
        r1.setSide(RoomSideDirection.WEST, mazeFactory.makeWall());

        r2.setSide(RoomSideDirection.NORTH, mazeFactory.makeWall());
        r2.setSide(RoomSideDirection.EAST, mazeFactory.makeWall());
        r2.setSide(RoomSideDirection.SOUTH, mazeFactory.makeWall());
        r2.setSide(RoomSideDirection.WEST, door);

        maze.addRoom(r1);
        maze.addRoom(r2);

        return maze;
    }

}
