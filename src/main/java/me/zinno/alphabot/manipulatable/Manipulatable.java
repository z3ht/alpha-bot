package me.zinno.alphabot.manipulatable;

import me.zinno.alphabot.data.node.DataNode;

public interface Manipulatable<T extends DataNode> {

    default double getPriority() {
        return 0;
    }

    default double getAvailability(T data) {
        return 0;
    }

    T manipulate(T data);

}
