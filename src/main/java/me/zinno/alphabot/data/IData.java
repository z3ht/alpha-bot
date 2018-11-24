package me.zinno.alphabot.data;

import me.zinno.alphabot.data.Updatable;
import rlbot.flat.GameTickPacket;

public interface IData<T extends GameTickPacket> extends Updatable<T> {
}
