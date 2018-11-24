package me.zinno.alphabot.data;

import me.zinno.alphabot.data.ball.BallData;
import me.zinno.alphabot.data.boost.BoostData;
import me.zinno.alphabot.data.car.CarData;
import me.zinno.alphabot.data.controller.ControlsOutput;

import java.util.Collections;

public class SampleDataNode extends DataNode<ControlsOutput> {

    public final CarData[] carData;
    public final BallData ballData;
    public final BoostData boostData;

    public SampleDataNode(CarData[] carData, BallData ballData, BoostData boostData, int playerIndex) {
        super(playerIndex);

        this.carData = carData;
        this.ballData = ballData;
        this.boostData = boostData;

        Collections.addAll(updatableList, carData);
        updatableList.add(ballData);
        updatableList.add(boostData);
    }

    @Override
    protected ControlsOutput updateControllerState() {
        return new ControlsOutput();
    }
}
