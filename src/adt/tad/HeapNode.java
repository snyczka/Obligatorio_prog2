package adt.tad;

public class HeapNode<K extends Comparable, T>{

    private K key;

    private T data;

    public HeapNode(K key, T data){
        this.data = data;
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
