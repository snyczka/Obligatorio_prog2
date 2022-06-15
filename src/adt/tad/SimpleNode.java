package adt.tad;

public class SimpleNode<T> {

    private T data;
    private SimpleNode<T> next;

    public SimpleNode(T inputData){
        this.data = inputData;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SimpleNode<T> getNext() {
        return next;
    }

    public void setNext(SimpleNode<T> next) {
        this.next = next;
    }

    public boolean equals(SimpleNode<T> comparative){
        boolean result = this.getData().equals(comparative.getData());
        return result;
    }

}
