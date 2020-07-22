package br.code.maze;

public class EnchantedMazeGame extends MazeGame {

    public Room makeRoom(int i) {
        return new EnchantedRoom(i, castSpell());
    }

    public Door makeDoor(Room r1, Room r2) {
        return new DoorNeedingSpell(r1, r2);
    }

    protected Spell castSpell(){
        return new Spell();
    }

}
