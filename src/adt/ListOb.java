package adt;

import exeptions.InvalidPosition;
import exeptions.NonExistantElement;

public interface ListOb<T> {

    public void add(int postiton, T input)throws InvalidPosition;

    public T remove(int position) throws NonExistantElement;

    public boolean contains(T seeker);

    public T get(int position);

}
