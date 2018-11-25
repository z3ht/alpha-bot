package me.zinno.alphabot.manipulatable.controller.boost;

import me.zinno.alphabot.data.node.SampleDataNode;
import rlbot.ControllerState;

public class AlwaysBoostController extends BoostController<SampleDataNode> {

    @Override
    public float getAvailability(SampleDataNode data) {
        return 0;
    }

    @Override
    public SampleDataNode order(SampleDataNode data) {
        ControllerState controllerState = data.controllerState;
        controllerState.getPitch();

        return data;
    }
}
