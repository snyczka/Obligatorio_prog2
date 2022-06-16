package adt.tad;

import exeptions.InvalidKey;

public class HeapImp<K extends Comparable, T> implements HeapOb<K, T>{

    private int size;
    private boolean isMax;
    private HeapNode<K, T>[] heapArray;


    public HeapImp(K firstKey, T firstData, boolean isItMax){
        this.heapArray = new HeapNode[3];
        this.heapArray[0] = new HeapNode<K, T>(firstKey, firstData);
        this.isMax = isItMax;
        this.size = 1;
    }


    @Override
    public void insert(K key, T data){
        this.getHeapArray()[this.getSize()] = new HeapNode<K, T>(key, data);
        int position = this.getSize();
        if(this.isMax){
            while(key.compareTo(this.getHeapArray()[(position-1)/2].getKey()) > 0 && position > 0){
                 HeapNode<K, T> temp = this.getHeapArray()[(position-1)/2];
                 this.getHeapArray()[(position-1)/2] = this.getHeapArray()[position];
                 this.getHeapArray()[position] = temp;
                 position = (position-1)/2;
            }
        }else{
            while(key.compareTo(this.getHeapArray()[(position-1)/2].getKey()) < 0 && position > 0) {
                HeapNode<K, T> temp = this.getHeapArray()[(position - 1) / 2];
                this.getHeapArray()[(position - 1) / 2] = this.getHeapArray()[position];
                this.getHeapArray()[position] = temp;
                position = (position - 1) / 2;
            }
        }
        this.setSize(this.getSize() + 1);
        if(this.getHeapArray().length == this.getSize()){
            int newSize = ((this.getSize()- 1)*2)+1; //Agrega nuevo nivel vacio al heap
            HeapNode<K, T>[] newLevel = new HeapNode[newSize];
            for(int i = 0; i < this.getSize(); i++){ //Carga valores al nuevo heap
                newLevel[i] = this.getHeapArray()[i];
            }
            this.setHeapArray(newLevel);
        }
    }

    @Override
    public T remove(K key) throws InvalidKey {
        HeapNode<K, T> seeker = null;
        int position = -1;
        for(int i = 0; i < this.getSize() && seeker == null; i++){
            if(key.compareTo(this.getHeapArray()[i]) == 0){
                seeker = this.getHeapArray()[i];
                position = i;
            }
        }
        if(seeker == null){
            throw new InvalidKey();
        }else{
            this.getHeapArray()[position] = this.getHeapArray()[this.getSize()-1];
            seeker = this.getHeapArray()[position];
            this.getHeapArray()[this.getSize()-1] = null;
            if(this.isMax){
                if(this.getHeapArray()[(position-1)/2].getKey().compareTo(seeker.getKey()) < 0 && position > 0){
                    do {
                        HeapNode<K, T> temp = this.getHeapArray()[(position-1)/2];
                        this.getHeapArray()[(position-1)/2] = this.getHeapArray()[position];
                        this.getHeapArray()[position] = temp;
                        position = (position-1)/2;
                    }while (key.compareTo(this.getHeapArray()[(position-1)/2].getKey()) > 0 && position > 0);
                }else if (this.getHeapArray()[(position*2)+1].getKey().compareTo(seeker.getKey()) > 0 && position == 0){

                }

            }else {

            }
        }

        return seeker.getData();
    }




    @Override
    public T get(K key){
        return this.getNode(key).getData();
    }

    private HeapNode<K, T> getNode(K key){
        HeapNode<K, T> result = null;
        for(int i = 0; i < this.getSize() && result == null; i++){
            if(key.compareTo(this.getHeapArray()[i]) == 0){
                result = this.getHeapArray()[i];
            }
        }
        return result;
    }

    @Override
    public int size() {
        return this.getSize();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isMax() {
        return isMax;
    }

    public void setMax(boolean max) {
        isMax = max;
    }

    public HeapNode<K, T>[] getHeapArray() {
        return heapArray;
    }

    public void setHeapArray(HeapNode<K, T>[] heapArray) {
        this.heapArray = heapArray;
    }
}
