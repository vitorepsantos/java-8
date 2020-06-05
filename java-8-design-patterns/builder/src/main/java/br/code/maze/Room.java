package br.code.maze;

public interface Room {

    int getId();

    void setSide(RoomSideDirection direction, RoomSide roomSide);

}
