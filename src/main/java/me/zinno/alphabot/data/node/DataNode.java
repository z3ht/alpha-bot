package me.zinno.alphabot.data.node;

import rlbot.ControllerState;

public abstract class DataNode<U extends ControllerState> {

    public U controllerState;

    public final int playerIndex;

    public DataNode(U controllerState, int playerIndex) {
        this.controllerState = controllerState;
        this.playerIndex = playerIndex;
    }
}
