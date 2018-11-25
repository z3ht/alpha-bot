package me.zinno.alphabot.manipulatable.state;

import me.zinno.alphabot.data.node.DataNode;
import me.zinno.alphabot.delegator.ManipulatableDelegator;
import me.zinno.alphabot.manipulatable.Manipulatable;

public abstract class State<T extends DataNode> implements Manipulatable<T> {

    protected ManipulatableDelegator boostDelegator;
    protected ManipulatableDelegator controllerDelegator;

    public State(ManipulatableDelegator boostDelegator, ManipulatableDelegator controllerDelegator) {
        this.boostDelegator = boostDelegator;
        this.controllerDelegator = controllerDelegator;
    }

}
