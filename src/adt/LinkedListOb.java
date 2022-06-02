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
    public void add(int posititon, T input)throws InvalidPosition {
        if(posititon >= this.getSize()){
            throw new InvalidPosition();
        }
        SimpleNode<T> addition = new SimpleNode<T>(input);
        if(this.getFirst() == null){
         this.setFirst(addition);
         this.setLast(addition);
        }else if(posititon == 0){
            addition.setNext(this.getFirst());
            this.setFirst(addition);
        }else if(posititon == this.getSize() -1){
            addition.setNext(this.getLast());
            this.setLast(addition);
        }else{
                SimpleNode<T> mover = this.getFirst();
                for(int x = 0; x < posititon; x++){
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

        SimpleNode<T> candidate = this.getFirst();
        if(position == 0){
            this.setFirst(candidate.getNext());
        }else{
            for (int x = 0; x < position - 1; x++) {
                candidate = candidate.getNext();
            }
            SimpleNode<T> parent = candidate;
            candidate = candidate.getNext();
            parent.setNext(candidate);

        }
        return candidate.getData();
    }

    @Override
    public boolean contains(T seeker) {
        boolean existence = false;
        SimpleNode<T> finder = this.getFirst();
        int tracker = 0;
        while (existence == false && tracker < this.getSize()){
            if(finder.getData().equals(seeker)){
                existence = true;
            }
            finder = finder.getNext();
            tracker++;
        }
        return existence;
    }

    @Override
    public T get(int position) throws NonExistantElement{
        if(position >= this.getSize()){
            throw new NonExistantElement();
        }
        T result = null;
        SimpleNode<T> finder = this.getFirst();
        if(position == this.getSize() - 1){
            finder = this.getLast();
        }else{
            for (int x = 0; x < position; x++){
                finder = finder.getNext();
            }
        }
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
