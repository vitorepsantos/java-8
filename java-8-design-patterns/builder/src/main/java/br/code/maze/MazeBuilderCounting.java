package br.code.maze;

public class MazeBuilderCounting extends MazeBuilder { /** Builder (Concrete Class) **/

    private int doors;
    private int rooms;

    public MazeBuilderCounting() {
        this.doors = 0;
        this.rooms = 0;
    }

    public void addWall(int n, RoomSideDirection direction) {}

    public int getCounts() {
        return doors + rooms;
    }

    public void buildRoom(int room) {
        this.rooms += 1;
    }

    public void buildDoor(int roomFrom, int roomTo) {
        this.doors += 1;
    }


}
