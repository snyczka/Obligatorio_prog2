package adt;

import exeptions.InvalidPosition;

public interface ListOb<T> {

    public void add(int postiton, T input)throws InvalidPosition;

    public void remove(int position);

    public boolean contains(T seeker);

    public T get(int position);

}
