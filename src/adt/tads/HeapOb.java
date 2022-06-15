package adt.tads;

public interface HeapOb<K extends Comparable, T> {

    public void insert();

    public T removeMax();

    public T removeMin();

    public T get();

    public int size();

}
