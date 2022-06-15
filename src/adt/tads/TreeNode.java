package adt.tads;

public class TreeNode<K extends Comparable, T> {

    public K key;
    public T data;
    public TreeNode<K, T> leftChild;
    public TreeNode<K, T> rightChild;
    public K parentKey;


    public TreeNode(K inputKey, T inputData, K parentKey) {
        this.key = inputKey;
        this.data = inputData;
        this.parentKey = parentKey;
    }

    public TreeNode(K inputKey, T inputData) {
        this.key = inputKey;
        this.data = inputData;
        this.leftChild = null;
        this.rightChild = null;
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

    public TreeNode<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    public K getParentKey() {
        return parentKey;
    }

    public void setParentKey(K parentKey) {
        this.parentKey = parentKey;
    }
}
