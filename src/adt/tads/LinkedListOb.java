package adt.tads;

import exeptions.EmptyQueueException;
import exeptions.EmptyStackException;
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
    public void add(T value){
        addToTheEnd(value);
        size++;
    }

    private void addToTheEnd(T value) {
        if (value != null) {

            SimpleNode<T> elementToAdd = new SimpleNode<>(value);

            if (this.first == null) { // si la lista es vacia

                this.first = elementToAdd;
                this.last = elementToAdd;

            } else { // en caso de no ser vacia se agrega al final

                this.last.setNext(elementToAdd);
                this.last = elementToAdd;
            }

        } else {
            // si el elemento es vacio se ignora
        }
    }

    @Override
    public void remove(int position) throws NonExistantElement {
        if(position >= this.getSize()){
            throw new NonExistantElement();
        }
        SimpleNode<T> candidate = this.getFirst();
        if(position == 0){
            this.setFirst(candidate.getNext());
            size--;
        }else{
            for (int x = 0; x < position - 1; x++) {
                candidate = candidate.getNext();
            }
            SimpleNode<T> parent = candidate;
            candidate = candidate.getNext();
            parent.setNext(candidate);
            size--;
        }
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
        this.addToTheEnd(input);
        size++;
    }

    private void addToBeginning(T value) {
        if (value != null) {

            SimpleNode<T> elementToAdd = new SimpleNode<>(value);

            if (this.first == null) { // si la lista es vacia

                this.first = elementToAdd;
                this.last = elementToAdd;

            } else { // en caso de no ser vacia se agrega al comienzo

                elementToAdd.setNext(this.first);
                this.first = elementToAdd;
            }

        } else {
            // si el elemento es vacio se ignora
        }
    }

    @Override
    public void deQueue() throws EmptyQueueException {
        try {
            remove(0);
        } catch (NonExistantElement e) {
            e.printStackTrace();
        }
    }

    @Override
    public void push(T input) {
        this.addToBeginning(input);
    }

    @Override
    public void pop() throws EmptyStackException {
        try {
            remove(0);
        } catch (NonExistantElement e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size(){
        return this.getSize();
    }
}
