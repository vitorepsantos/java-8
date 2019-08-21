package br.code.maze.pojo.enchanted;

import br.code.maze.pojo.Door;
import br.code.maze.pojo.Room;

public class EnchantedDoor implements Door {
    private Room room1;
    private Room room2;
    public EnchantedDoor(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }
}
