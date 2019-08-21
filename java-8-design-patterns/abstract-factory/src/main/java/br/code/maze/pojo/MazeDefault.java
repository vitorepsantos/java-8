package br.code.maze.pojo;

import java.util.ArrayList;

public class MazeDefault implements Maze {

    private ArrayList<Room> maze;

    public MazeDefault() {
        this.maze = new ArrayList<Room>();
    }

    public void addRoom(Room r) {
        this.maze.add(r);
    }

}
