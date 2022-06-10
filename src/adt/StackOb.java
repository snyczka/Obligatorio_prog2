package adt;

import exeptions.EmptyStackException;
import exeptions.InvalidPosition;
import exeptions.NonExistantElement;

public interface StackOb<T> {

    public void push(T input) throws InvalidPosition;

    public void pop() throws EmptyStackException;

    public int size();

}
