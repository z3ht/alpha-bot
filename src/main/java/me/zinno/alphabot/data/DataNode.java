package me.zinno.alphabot.data;

import rlbot.ControllerState;
import rlbot.flat.GameTickPacket;

import java.util.LinkedList;
import java.util.List;

public abstract class DataNode<T extends ControllerState> {

    protected final List<Updatable<GameTickPacket>> updatableList;

    public T controllerState;

    public final int playerIndex;

    public DataNode(int playerIndex) {
        this.updatableList = new LinkedList<>();
        this.playerIndex = playerIndex;
    }

    final void update(GameTickPacket packet) {
        this.controllerState = updateControllerState();
        this.updatableList
                .forEach(data -> data.update(packet));
    }

    protected abstract T updateControllerState();

}
