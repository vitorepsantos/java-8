package br.code.maze.pojo.enchanted;

import br.code.maze.MazeFactory;
import br.code.maze.pojo.WallDefault;
import br.code.maze.pojo.Door;
import br.code.maze.pojo.Maze;
import br.code.maze.pojo.MazeDefault;
import br.code.maze.pojo.Room;
import br.code.maze.pojo.Wall;

public class EnchantedMazeFactory implements MazeFactory {
    public Maze makeMaze() {
            return new MazeDefault();
    }

    public Wall makeWall() {
        return new WallDefault();
    }

    public Room makeRoom(int i) {
        return new EnchantedRoom(i);
    }

    public Door makeDoor(Room a, Room b) {
        return new EnchantedDoor(a, b);
    }
}
