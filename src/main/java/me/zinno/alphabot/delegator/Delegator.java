package me.zinno.alphabot.delegator;

import java.util.Collections;
import java.util.List;

public abstract class Delegator<T, U> {

    private List<T> registeredDelegatees;

    public Delegator() {
        this(Collections.emptyList());
    }

    public Delegator(List<T> delegatees) {
        this.registeredDelegatees = delegatees;
    }

    public abstract T fetchMax(U data);

    public abstract List<T> sort(U data);

    public List<T> getRegisteredDelegatees() {
        return registeredDelegatees;
    }

    public final Delegator<T, U> registerDelegatee(T delegatees) {
        registeredDelegatees.add(delegatees);
        return this;
    }

    public void setRegisteredDelegatees(List<T> registeredDelegatees) {
        this.registeredDelegatees = registeredDelegatees;
    }

}
