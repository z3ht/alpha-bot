package me.zinno.alphabot.delegator;

import javafx.util.Pair;
import me.zinno.alphabot.data.DataNode;
import me.zinno.alphabot.manipulatable.Manipulatable;

import java.util.List;

public class ManipulatableDelegator<U extends DataNode> extends Delegator<Manipulatable<U>, U> {

    public ManipulatableDelegator() {
        super();
    }

    public ManipulatableDelegator(List<Manipulatable<U>> delegatees) {
        super(delegatees);
    }

    @Override
    public Manipulatable<U> fetch(U dataNode) {
        Pair<Float, Manipulatable<U>> maxDelegatee = new Pair<>(-10F, null);

        for(Manipulatable<U> delegatee : super.getRegisteredDelegatees()) {
            final float availability = delegatee.getAvailability(dataNode);
            if(availability > maxDelegatee.getKey())
                maxDelegatee = new Pair<>(availability, delegatee);
        }

        return maxDelegatee.getValue();
    }
}
