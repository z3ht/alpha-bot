package me.zinno.alphabot.delegator;

import javafx.util.Pair;
import me.zinno.alphabot.data.node.DataNode;
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
    public Manipulatable<U> fetchMax(U data) {
        Pair<Double, Manipulatable<U>> maxDelegatee = new Pair<>(-10D, null);
        for(Manipulatable<U> delegatee : super.getRegisteredDelegatees()) {
            final double status = delegatee.getAvailability(data) + delegatee.getPriority();
            if (status > maxDelegatee.getKey())
                maxDelegatee = new Pair<>(status, delegatee);
        }
        return maxDelegatee.getValue();
    }

    @Override
    public List<Manipulatable<U>> sort(U data) {
        super.getRegisteredDelegatees().sort(
                (Manipulatable<U> m1, Manipulatable<U> m2) -> {
                    double val1 = m1.getAvailability(data) + m1.getPriority();
                    double val2 = m2.getAvailability(data) + m2.getPriority();
                    if (val1 == val2)
                        return 0;
                    else if (val1 > val2)
                        return 1;
                    return -1;
                }
        );
        return super.getRegisteredDelegatees();
    }


}
