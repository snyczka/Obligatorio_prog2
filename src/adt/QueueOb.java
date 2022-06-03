package adt;

import exeptions.InvalidPosition;
import exeptions.NonExistantElement;

public interface QueueOb<T> {

    public void enQueue(T input) throws InvalidPosition;

    public T deQueue() throws NonExistantElement;

    public int size();

}
