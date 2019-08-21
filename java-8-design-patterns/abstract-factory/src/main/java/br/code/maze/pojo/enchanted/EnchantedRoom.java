package br.code.maze.pojo.enchanted;

import br.code.maze.pojo.RoomSide;
import br.code.maze.pojo.Room;
import br.code.maze.pojo.RoomSideDirection;

import java.util.HashMap;
import java.util.Map;

public class EnchantedRoom implements Room {
    private int id;
    private Map<RoomSideDirection, RoomSide> roomMap;

    public EnchantedRoom(int i) {
        this.id = i;
        this.roomMap = new HashMap<RoomSideDirection, RoomSide>();
    }

    public void setSide(RoomSideDirection direction, RoomSide roomSide) {
        this.roomMap.put(direction, roomSide);
    }
}
