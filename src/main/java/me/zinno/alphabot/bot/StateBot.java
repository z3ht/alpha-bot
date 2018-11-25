package me.zinno.alphabot.bot;

import me.zinno.alphabot.data.Data;
import me.zinno.alphabot.data.bank.controller.ControlsOutput;
import me.zinno.alphabot.data.node.DataNode;
import me.zinno.alphabot.delegator.ManipulatableDelegator;
import rlbot.Bot;
import rlbot.ControllerState;
import rlbot.flat.GameTickPacket;

public abstract class StateBot<U extends DataNode<? extends ControllerState>> implements Bot {

    private final int playerIndex;

    private final ManipulatableDelegator<U> stateDelegator;

    private Data<U> data;

    public StateBot(ManipulatableDelegator<U> stateDelegator, Data<U> data, int playerIndex) {
        this.data = data;
        this.stateDelegator = stateDelegator;
        this.playerIndex = playerIndex;
    }

    @Override
    public int getIndex() {
        return playerIndex;
    }

    @Override
    public ControllerState processInput(GameTickPacket packet) {

        if (packet.playersLength() <= playerIndex || packet.ball() == null || !packet.gameInfo().isRoundActive()) {
            // Just return immediately if something looks wrong with the data. This helps us avoid stack traces.
            return new ControlsOutput();
        }

        data.update(packet);

        return stateDelegator.fetchMax(data.getNode()).manipulate(data.getNode()).controllerState;
    }

}
