package me.zinno.alphabot.data.node;

import me.zinno.alphabot.data.bank.ball.BallData;
import me.zinno.alphabot.data.bank.boost.BoostData;
import me.zinno.alphabot.data.bank.car.CarData;
import me.zinno.alphabot.data.bank.controller.ControlsOutput;

public class SampleDataNode extends DataNode<ControlsOutput> {

    public final int numCars;

    public final CarData[] carsData;
    public final BallData ballData;
    public final BoostData boostData;

    public SampleDataNode(CarData[] carsData, BallData ballData, BoostData boostData, int playerIndex) {
        super(
                new ControlsOutput(),
                playerIndex
        );

        this.numCars = carsData.length;

        this.carsData = carsData;
        this.ballData = ballData;
        this.boostData = boostData;
    }
}
