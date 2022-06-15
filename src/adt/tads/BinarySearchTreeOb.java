package adt.tads;

public interface BinarySearchTreeOb<K extends Comparable, T> {

    public void insert(K key, T data, K parentKey);

    public T find(K key);

    public void delete(K key);

    public int size(TreeNode<K,T> raiz);
}
