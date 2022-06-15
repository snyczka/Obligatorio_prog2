package tads;

import exeptions.NonExistantElement;

public interface ListOb<T> {

    public void add(T value);

    public void remove(int position) throws NonExistantElement;

    public boolean contains(T seeker);

    public T get(int position) throws NonExistantElement;

}
