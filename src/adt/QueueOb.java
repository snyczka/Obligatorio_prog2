package adt;

import exeptions.EmptyQueueException;
import exeptions.InvalidPosition;

public interface QueueOb<T> {

    public void enQueue(T input) throws InvalidPosition;

    public void deQueue() throws  EmptyQueueException;

    public int size();

}
