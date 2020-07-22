package br.code.maze;

public class MazeGame {

    public Maze createMaze() {
        Maze aMaze = makeMaze();

        Room r1 = makeRoom(1);
        Room r2 = makeRoom(2);
        Door theDoor = makeDoor(r1, r2);
        aMaze.addRoom(r1);
        aMaze.addRoom(r2);
        r1.setSide(RoomSideDirection.NORTH, makeWall());
        r1.setSide(RoomSideDirection.EAST, theDoor);
        r1.setSide(RoomSideDirection.SOUTH, makeWall());
        r1.setSide(RoomSideDirection.WEST, makeWall());
        r2.setSide(RoomSideDirection.NORTH, makeWall());
        r2.setSide(RoomSideDirection.EAST, makeWall());
        r2.setSide(RoomSideDirection.SOUTH, makeWall());
        r2.setSide(RoomSideDirection.WEST, theDoor);

        return aMaze;
    }

    public Maze makeMaze() {
        return new MazeDefault();
    }

    public Room makeRoom(int i) {
        return new RoomDefault(i);
    }

    public Wall makeWall() {
        return new WallDefault();
    }

    public Door makeDoor(Room r1, Room r2) {
        return new DoorDefault(r1, r2);
    }
}
