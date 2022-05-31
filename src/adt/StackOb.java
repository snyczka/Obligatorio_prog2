package adt;

import exeptions.InvalidPosition;
import exeptions.NonExistantElement;

public interface StackOb<T> {

    public void push(T input) throws InvalidPosition;

    public T pop() throws NonExistantElement;

}
