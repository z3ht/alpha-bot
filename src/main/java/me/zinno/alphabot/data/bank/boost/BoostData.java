package me.zinno.alphabot.data.bank.boost;

import me.zinno.alphabot.util.vector.Vector3;
import rlbot.cppinterop.RLBotDll;
import rlbot.flat.BoostPadState;
import rlbot.flat.FieldInfo;
import rlbot.flat.GameTickPacket;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Information about where boost pads are located on the field and what status they have.
 *
 * This class is here for your convenience, it is NOT part of the framework. You can change it as much
 * as you want, or delete it.
 */
public class BoostData {

    private final ArrayList<BoostPad> orderedBoosts = new ArrayList<>();

    private final ArrayList<BoostPad> fullBoosts = new ArrayList<>();
    private final ArrayList<BoostPad> smallBoosts = new ArrayList<>();

    public ArrayList<BoostPad> getFullBoosts() {
        return fullBoosts;
    }

    public ArrayList<BoostPad> getSmallBoosts() {
        return smallBoosts;
    }

    @Override
    public void update(GameTickPacket packet) {
        if (packet.boostPadStatesLength() > orderedBoosts.size()) {
            try {
                loadFieldInfo(RLBotDll.getFieldInfo());
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        for (int i = 0; i < packet.boostPadStatesLength(); i++) {
            BoostPadState boost = packet.boostPadStates(i);
            BoostPad existingPad = orderedBoosts.get(i); // existingPad is also referenced from the fullBoosts and smallBoosts lists
            existingPad.setActive(boost.isActive());
        }
    }

    private void loadFieldInfo(FieldInfo fieldInfo) {

        synchronized (orderedBoosts) {

            orderedBoosts.clear();
            fullBoosts.clear();
            smallBoosts.clear();

            for (int i = 0; i < fieldInfo.boostPadsLength(); i++) {
                rlbot.flat.BoostPad flatPad = fieldInfo.boostPads(i);
                BoostPad ourPad = new BoostPad(new Vector3(flatPad.location()), flatPad.isFullBoost());
                orderedBoosts.add(ourPad);
                if (ourPad.isFullBoost()) {
                    fullBoosts.add(ourPad);
                } else {
                    smallBoosts.add(ourPad);
                }
            }
        }
    }
}
