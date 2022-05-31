package adt;

import exeptions.InvalidPosition;
import exeptions.NonExistantElement;

public class LinkedListOb<T> implements ListOb<T>, QueueOb<T>, StackOb<T>{

    private SimpleNode<T> first;
    private int size;
    private SimpleNode<T> last;

    public LinkedListOb(SimpleNode<T> inputFirst){
        this.first = inputFirst;
        this.last = inputFirst;
        this.size = 1;
    }

    public LinkedListOb(){
        this.size = 0;
        this.first = null;
        this.last = null;
    }


    public SimpleNode<T> getFirst() {
        return first;
    }

    public void setFirst(SimpleNode<T> first) {
        this.first = first;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public SimpleNode<T> getLast() {
        return last;
    }

    public void setLast(SimpleNode<T> last) {
        this.last = last;
    }

    @Override
    public void add(int postiton, T input)throws InvalidPosition {
        if(postiton >= this.getSize()){
            throw new InvalidPosition();
        }
        SimpleNode<T> addition = new SimpleNode<T>(input);
        if(this.getFirst() == null){
         this.setFirst(addition);
         this.setLast(addition);
        }else{
            SimpleNode<T> mover = this.getFirst();
            for(int x = 0; x < postiton; x++){
                mover = mover.getNext();
            }
            addition.setNext(mover.getNext());
            mover.setNext(addition);
        }

    }

    @Override
    public T remove(int position) throws NonExistantElement {
        if(position >= this.getSize()){
            throw new NonExistantElement();
        }
        SimpleNode<T> candidate = this.getFirst().getNext();
        for(int x = 0; x < position; x++){

        }

        return candidate.getData();
    }

    @Override
    public boolean contains(T seeker) {
        boolean existence = false;
        SimpleNode<T> finder = this.getFirst();
        int tracker = 1;
        while (existence == false && tracker <= this.getSize()){
            if(finder.getData().equals(seeker)){
                existence = true;
            }
            finder = finder.getNext();
            tracker++;
        }
        return existence;
    }

    @Override
    public T get(int position) {
        T result = null;


        return result;
    }

    @Override
    public void enQueue(T input) throws InvalidPosition {
        this.add(0, input);
    }

    @Override
    public T deQueue() throws NonExistantElement {
        T extraction = this.remove(this.getSize() -1);
        return extraction;
    }

    @Override
    public void push(T input) throws InvalidPosition {
        this.add(0, input);
    }

    @Override
    public T pop() throws NonExistantElement{
        T extraction = this.remove(0);
        return extraction;
    }
}
