package br.code.maze;

import java.util.HashMap;
import java.util.Map;

public class RoomWithABomb implements Room {

    private int id;
    private Map<RoomSideDirection, RoomSide> roomMap;

    public RoomWithABomb(int i) {
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
