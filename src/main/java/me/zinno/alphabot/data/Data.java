package me.zinno.alphabot.data;

import me.zinno.alphabot.data.node.DataNode;
import me.zinno.alphabot.delegator.ManipulatableDelegator;
import me.zinno.alphabot.manipulatable.Manipulatable;
import rlbot.ControllerState;
import rlbot.flat.GameTickPacket;

import java.util.Collections;
import java.util.List;

public abstract class Data<T extends DataNode<? extends ControllerState>> implements IData<GameTickPacket> {

    protected final ManipulatableDelegator<T> updaterDelegator;
    private final int playerIndex;

    private boolean isFirstUpdate;

    private T node;

    public Data(ManipulatableDelegator<T> updaterDelegator, int playerIndex) {
        this.updaterDelegator = updaterDelegator;
        this.playerIndex = playerIndex;

        this.isFirstUpdate = true;
    }

    public abstract T createNode(GameTickPacket packet, int playerIndex);

    public T getNode() {
        return this.node;
    }

    @Override
    public final void update(GameTickPacket packet) {
        if(isFirstUpdate) {
            this.node = createNode(packet, this.playerIndex);
            isFirstUpdate = false;
        }

        List<Manipulatable<T>> manipulatableList = this.updaterDelegator.sort(node);
        Collections.reverse(manipulatableList);
        for (Manipulatable<T> manipulatable : manipulatableList) {
            this.node = manipulatable.manipulate(node);
        }

    }
}
