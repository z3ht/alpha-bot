package me.zinno.alphabot.data;

import rlbot.flat.GameTickPacket;

public abstract class Data<U extends DataNode> implements IData {

    private boolean isFirstUpdate;
    private int playerIndex;

    private U node;

    public Data(int playerIndex) {
        this.isFirstUpdate = true;
    }

    public abstract U createNode(GameTickPacket packet, int playerIndex);

    public U getNode() {
        return this.node;
    }

    @Override
    public final void update(GameTickPacket packet) {
        if(isFirstUpdate) {
            this.node = createNode(packet, this.playerIndex);
            isFirstUpdate = false;
        }
        node.update(packet);
    }
}
