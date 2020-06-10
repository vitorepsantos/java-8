package br.code.maze;

public class MazeBuilderDefault extends MazeBuilder { /** Builder (Concrete Class) **/

    private Maze currentMaze;

    public MazeBuilderDefault() {
        this.currentMaze = null;
    }

    public void buildMaze() {
        this.currentMaze = new MazeDefault();
    }

    public void buildRoom(int n) {
        if (this.currentMaze.roomNo(n) == null) {
            Room room = new RoomDefault(n);
            this.currentMaze.addRoom(room);
            room.setSide(RoomSideDirection.NORTH, new WallDefault());
            room.setSide(RoomSideDirection.SOUTH, new WallDefault());
            room.setSide(RoomSideDirection.EAST, new WallDefault());
            room.setSide(RoomSideDirection.WEST, new WallDefault());
        }
    }

    public void buildDoor(int n1, int n2) {
        Room r1 = this.currentMaze.roomNo(n1);
        Room r2 = this.currentMaze.roomNo(n2);
        Door d = new DoorDefault(r1, r2);

        r1.setSide(commonWall(r1, r2), d);
        r2.setSide(commonWall(r2, r1), d);
    }

    private RoomSideDirection commonWall(Room room1, Room room2) {
        // commonWall is a utility operation that determines the direction of the common wall between two rooms.
        return RoomSideDirection.NORTH;
    }

    public Maze getMaze() {
        return this.currentMaze;
    }

}
