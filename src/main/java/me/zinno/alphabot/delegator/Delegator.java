package me.zinno.alphabot.delegator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class Delegator<T, U> {

    private List<T> registeredDelegatees = new LinkedList<>();

    public Delegator() {}

    public Delegator(List<T> delegatees) {
        this.registeredDelegatees = delegatees;
    }

    public abstract T fetch(U data);

    public void registerDelegatee(T... delegatees) {
        Arrays.stream(delegatees).forEach(registeredDelegatees::add);
    }

    public void setRegisteredDelegatees(List<T> registeredDelegatees) {
        this.registeredDelegatees = registeredDelegatees;
    }

    public List<T> getRegisteredDelegatees() {
        return registeredDelegatees;
    }

}
