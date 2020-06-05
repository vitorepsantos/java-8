package br.code.maze;

import java.util.HashMap;
import java.util.Map;

public class RoomDefault implements Room {

    private int id;
    private Map<RoomSideDirection, RoomSide> roomMap;

    public RoomDefault(int i) {
        this.id = i;
        this.roomMap = new HashMap<RoomSideDirection, RoomSide>();
    }

    public int getId() {
        return this.id;
    }

    public void setSide(RoomSideDirection direction, RoomSide roomSide) {
        this.roomMap.put(direction, roomSide);
    }

}
