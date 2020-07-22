package br.code.maze;

import java.util.HashMap;
import java.util.Map;

public class EnchantedRoom implements Room {

    private int id;
    private Map<RoomSideDirection, RoomSide> roomMap;
    private Spell spell;

    public EnchantedRoom(int i, Spell spell) {
        this.id = i;
        this.roomMap = new HashMap<RoomSideDirection, RoomSide>();
        this.spell = spell;
    }

    public int getId() {
        return this.id;
    }

    public void setSide(RoomSideDirection direction, RoomSide roomSide) {
        this.roomMap.put(direction, roomSide);
    }

}
