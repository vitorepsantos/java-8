package br.code.maze.pojo.bombed;

import br.code.maze.MazeFactory;
import br.code.maze.pojo.Door;
import br.code.maze.pojo.DoorDefault;
import br.code.maze.pojo.Maze;
import br.code.maze.pojo.MazeDefault;
import br.code.maze.pojo.Room;
import br.code.maze.pojo.Wall;

public class BombedMazeFactory implements MazeFactory {
    public Maze makeMaze() {
            return new MazeDefault();
    }

    public Wall makeWall() {
        return new BombedWall();
    }

    public Room makeRoom(int i) {
        return new BombedRoom(i);
    }

    public Door makeDoor(Room a, Room b) {
        return new DoorDefault(a, b);
    }
}
