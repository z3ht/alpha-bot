package me.zinno.alphabot.data.car;

import me.zinno.alphabot.data.Updatable;
import me.zinno.alphabot.util.vector.Vector3;
import rlbot.flat.GameTickPacket;
import rlbot.flat.PlayerInfo;

/**
 * Basic information about the carData.
 *
 * This class is here for your convenience, it is NOT part of the framework. You can change it as much
 * as you want, or delete it.
 */
public class CarData implements Updatable<GameTickPacket> {

    /** The location of the carData on the field. (0, 0, 0) is center field. */
    public Vector3 position;

    /** The velocity of the carData. */
    public Vector3 velocity;

    /** The orientation of the carData */
    public CarOrientation orientation;

    /** Boost ranges from 0 to 100 */
    public double boost;

    /** True if the carData is driving on the ground, the wall, etc. In other words, true if you can steer. */
    public boolean hasWheelContact;

    /**
     * True if the carData is showing the supersonic and can demolish enemies on contact.
     * This is a close approximation for whether the carData is at max speed.
     */
    public boolean isSupersonic;

    /**
     * 0 for blue team, 1 for orange team.
     */
    public int team;


    public final int carIndex;

    public CarData(int carIndex) {
        this.carIndex = carIndex;
    }


    @Override
    public void update(GameTickPacket data) {
        PlayerInfo playerInfo = data.players(carIndex);

        this.position = new Vector3(playerInfo.physics().location());
        this.velocity = new Vector3(playerInfo.physics().velocity());
        this.orientation = CarOrientation.fromFlatbuffer(playerInfo);
        this.boost = playerInfo.boost();
        this.isSupersonic = playerInfo.isSupersonic();
        this.team = playerInfo.team();
        this.hasWheelContact = playerInfo.hasWheelContact();
    }
}
