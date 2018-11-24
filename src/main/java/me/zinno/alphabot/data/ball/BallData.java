package me.zinno.alphabot.data.ball;


import me.zinno.alphabot.data.Updatable;
import me.zinno.alphabot.util.vector.Vector3;
import rlbot.flat.BallInfo;
import rlbot.flat.GameTickPacket;

/**
 * Basic information about the ballData.
 *
 * This class is here for your convenience, it is NOT part of the framework. You can change it as much
 * as you want, or delete it.
 */
public class BallData implements Updatable<GameTickPacket> {
    public Vector3 position;
    public Vector3 velocity;
    public Vector3 spin;

    @Override
    public void update(GameTickPacket data) {
        final BallInfo ball = data.ball();

        this.position = new Vector3(ball.physics().location());
        this.velocity = new Vector3(ball.physics().velocity());
        this.spin = new Vector3(ball.physics().angularVelocity());
    }
}
