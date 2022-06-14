package adt;

public class HashNodeOb<K, T> {

    private K key;
    private T data;
    private boolean deleted;

    public HashNodeOb(K key, T data){
        this.key = key;
        this.data = data;
        this.deleted = false;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean equals(HashNodeOb<K, T> comparison){
        return this.getKey().equals(comparison.getKey());
    }

    public int hash(K key, int arraysize){
        return 0;
    }
}
