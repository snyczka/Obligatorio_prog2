package adt;

public class TreeNode<K extends Comparable, T> {

    private K key;
    private T data;
    private TreeNode<K, T> left;
    private TreeNode<K, T> right;

    public TreeNode(K inputKey, T inputData){
        this.key = inputKey;
        this.data = inputData;
        this.left = null;
        this.right = null;
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

    public TreeNode<K, T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<K, T> left) {
        this.left = left;
    }

    public TreeNode<K, T> getRight() {
        return right;
    }

    public void setRight(TreeNode<K, T> right) {
        this.right = right;
    }
}
