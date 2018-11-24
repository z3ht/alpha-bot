package me.zinno.alphabot.data;

import rlbot.flat.GameTickPacket;

public interface Updatable<T extends GameTickPacket> {

    void update(T data);

}
