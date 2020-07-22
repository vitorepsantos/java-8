package br.code.maze;

public class BombedMazeGame extends MazeGame {

    public Room makeRoom(int i) {
        return new RoomWithABomb(i);
    }

    public Wall makeWall() {
        return new BombedWall();
    }

}
