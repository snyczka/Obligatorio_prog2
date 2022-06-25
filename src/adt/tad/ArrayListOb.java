package adt.tad;

import exeptions.NonExistantElement;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayListOb<T> implements ListOb<T>{

    private T listArray[];
    private int size;

    public ArrayListOb(Class<T> type){
        this.listArray = (T[]) Array.newInstance(type, 10);
        this.size = 0;
    }



    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void add(T value) {
        if(listArray[this.getSize()] == null){
            this.listArray[this.getSize()] = value;
        }else {
            boolean notPlaced = true;
            for(int i = 0; notPlaced &&  i <this.getSize(); i++){
                if(listArray[i] == null){
                    listArray[i] = value;
                    notPlaced = false;
                }
            }
        }
        this.setSize(this.getSize() + 1);
        if(this.getSize() == this.listArray.length){
            T[] newArray = Arrays.copyOf(this.listArray, this.listArray.length * 10);
            for(int i = 0; this.listArray.length > i; i++){
                newArray[i] = this.listArray[i];
            }
            this.listArray = newArray;
        }
    }



    @Override
    public void remove(int position) throws NonExistantElement {
        if(position <= this.listArray.length){
            throw new NonExistantElement();
        }else {
            this.listArray[position] = this.listArray[this.size-1];
            this.listArray[this.size-1] = null;
            this.setSize(this.getSize() - 1);
        }

    }

    @Override
    public boolean contains(T seeker) {
        boolean result = false;

        for(int i = 0; !result &&  i <this.size; i++) {
            if (listArray[i] == seeker) {
                result = true;
            }
        }
        return result;

    }

    @Override
    public T get(int position) throws NonExistantElement {
        if(position >= this.listArray.length){
            throw new NonExistantElement();
        }
            T result = this.listArray[position];



        return result;
    }


    @Override
    public int size() {
        return this.getSize();
    }
}


