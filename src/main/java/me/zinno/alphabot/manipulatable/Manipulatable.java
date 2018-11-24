package me.zinno.alphabot.manipulatable;

import me.zinno.alphabot.data.DataNode;

public interface Manipulatable<T extends DataNode> {

    float getAvailability(T data);

    T manipulate(T data);

}
