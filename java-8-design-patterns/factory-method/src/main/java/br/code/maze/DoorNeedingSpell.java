package br.code.maze;

public class DoorNeedingSpell implements Door {
    private Room room1;
    private Room room2;
    public DoorNeedingSpell(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }
}
