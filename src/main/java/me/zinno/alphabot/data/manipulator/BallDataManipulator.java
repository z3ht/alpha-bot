package me.zinno.alphabot.data.manipulator;

import me.zinno.alphabot.manipulatable.Manipulatable;
import me.zinno.alphabot.util.vector.Vector3;
import rlbot.flat.BallInfo;
import rlbot.flat.GameTickPacket;

public class BallDataManipulator extends Manipulatable<GameTickPacket> {
    @Override
    public GameTickPacket manipulate(GameTickPacket data) {
        final BallInfo ball = data.ball();

        this.position = new Vector3(ball.physics().location());
        this.velocity = new Vector3(ball.physics().velocity());
        this.spin = new Vector3(ball.physics().angularVelocity());
    }
}
