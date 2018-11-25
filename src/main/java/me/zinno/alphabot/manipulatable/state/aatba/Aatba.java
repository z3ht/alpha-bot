package me.zinno.alphabot.manipulatable.state.aatba;

import me.zinno.alphabot.data.node.SampleDataNode;
import me.zinno.alphabot.delegator.ManipulatableDelegator;
import me.zinno.alphabot.manipulatable.controller.boost.AlwaysBoostController;
import me.zinno.alphabot.manipulatable.state.State;

import java.util.Arrays;

public class Aatba extends State<SampleDataNode> {

    public Aatba() {
        this(
                new ManipulatableDelegator<>(
                        Arrays.asList(
                                new AlwaysBoostController()
                        )
                ),
                new ManipulatableDelegator<>()
        );
    }

    public Aatba(ManipulatableDelegator boostDelegator, ManipulatableDelegator controllerDelegator) {
        super(boostDelegator, controllerDelegator);
    }

    @Override
    public double getAvailability(SampleDataNode data) {
        return 0;
    }

    @Override
    public SampleDataNode manipulate(SampleDataNode data) {
        return data;
    }
}
