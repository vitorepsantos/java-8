package br.code.maze.pojo;

import java.util.HashMap;
import java.util.Map;

public class RoomDefault implements Room {

    private int id;
    private Map<RoomSideDirection, RoomSide> roomMap;

    public RoomDefault(int i) {
        this.id = i;
        this.roomMap = new HashMap<RoomSideDirection, RoomSide>();
    }

    public void setSide(RoomSideDirection direction, RoomSide roomSide) {
        this.roomMap.put(direction, roomSide);
    }

}
