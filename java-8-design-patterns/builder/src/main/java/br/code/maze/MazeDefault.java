package br.code.maze;

import java.util.ArrayList;

public class MazeDefault implements Maze {

    private ArrayList<Room> maze;

    public MazeDefault() {
        this.maze = new ArrayList<Room>();
    }

    public void addRoom(Room r) {
        this.maze.add(r);
    }

    public Room roomNo(int n) {
        for (Room room: maze) {
            if (room.getId() == n) {
                return room;
            }
        }
        return null;
    }

}
