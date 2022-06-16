package adt;

import exeptions.InvalidKey;

public class HashTableOb<K, T> implements HashOb<K, T>{

    private static final int initialSize = 10;
    private HashNodeOb<K, T>[] hashArray;
    private float loadFactor = 0.8f;
    private int size;
    private int arraySize;

    public HashTableOb(K key, T data){
        this.hashArray = new HashNodeOb[initialSize];
        HashNodeOb<K, T> first = new HashNodeOb<K, T>(key, data);
        this.hashArray[this.hash(key)] = first;
        this.size = 1;
        this.arraySize = 10;
    }


    @Override
    public void put(K key, T value) {
        int position = this.hash(key);
        if(this.getHashArray()[position] == null || this.getHashArray()[position].isDeleted()){
            this.getHashArray()[position] = new HashNodeOb<K, T>(key, value);
        }else{
            position = collisionHelper(key, position);
            this.getHashArray()[position] = new HashNodeOb<K, T>(key, value);
        }
            this.setSize(this.getSize() + 1);
        if ((float) this.getSize()/this.getHashArray().length >= loadFactor){
            int newSize = this.getHashArray().length * 10;
            HashNodeOb<K, T>[] newLevel = new HashNodeOb[newSize];
            this.arraySize = newSize;
            for(int i = 0; i < this.getSize(); i++){
                int mover = this.hash(this.getHashArray()[i].getKey());
                if(newLevel[mover] == null){
                    newLevel[mover] = this.getHashArray()[i];
                }else{
                    while (newLevel[mover] != null){
                        mover++;
                        if(mover == newLevel.length-1){
                            mover = 0;
                        }
                    }
                    newLevel[mover] = this.getHashArray()[i];
                }
            }
            this.setHashArray(newLevel);
        }
    }

    private int collisionHelper(K key, int position){
        int newPosition;
        if(position == this.getHashArray().length-1){
            newPosition = 0;
        }else{
            newPosition = position++;
        }
        if(this.getHashArray()[newPosition] != null && !this.getHashArray()[newPosition].isDeleted()){
            newPosition = collisionHelper(key, newPosition);
        }


        return newPosition;
    }

    @Override
    public T get(K key) {
        T result = null;
        int counter = 0;
        int position = hash(key);
        if(this.getHashArray()[position].getKey().equals(key) && !this.getHashArray()[position].isDeleted()){
            result = this.getHashArray()[position].getData();
        }else if(this.getHashArray()[position].isDeleted()){
            do {
                if(position == this.getHashArray().length-1){
                    position = 0;
                }else {
                    position = position++;
                }
                counter++;
            }while ((!(this.getHashArray()[position].getKey().equals(key) && !this.getHashArray()[position].isDeleted())
            || !this.getHashArray()[position].getKey().equals(key) && this.getHashArray()[position].isDeleted())
                    && counter < this.getHashArray().length-1);
            if(this.getHashArray()[position].getKey().equals(key) && !getHashArray()[position].isDeleted()){
                result =this.getHashArray()[position].getData();
            }
        }


        return result;
    }


    @Override
    public void remove(K key) throws InvalidKey {

        int counter = 0;
        int position = hash(key);
        if(this.getHashArray()[position].getKey().equals(key) && !this.getHashArray()[position].isDeleted()){
            this.getHashArray()[position].setDeleted(true);
        }else if(this.getHashArray()[position].isDeleted()){
            do {
                if(position == this.getHashArray().length-1){
                    position = 0;
                }else {
                    position = position++;
                }
                counter++;
            }while ((!(this.getHashArray()[position].getKey().equals(key) && !this.getHashArray()[position].isDeleted())
                    || !this.getHashArray()[position].getKey().equals(key) && this.getHashArray()[position].isDeleted())
                    && counter < this.getHashArray().length-1);
            if(this.getHashArray()[position].getKey().equals(key) && !getHashArray()[position].isDeleted()){
                this.getHashArray()[position].setDeleted(true);
            }else throw new InvalidKey();
        }else throw new InvalidKey();


    }

    @Override
    public int size() {
        return getSize();
    }


    private int hash(K key){
        if(key instanceof Integer){
            return ((int)key)%this.arraySize;
        }else{
            return key.toString().length()%this.arraySize; //Se asume que cualquier K tendrá su método de string reescrito de ser necesario
        }
    }

    public HashNodeOb<K, T>[] getHashArray() {
        return hashArray;
    }

    public void setHashArray(HashNodeOb<K, T>[] hashArray) {
        this.hashArray = hashArray;
    }

    public float getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(float loadFactor) {
        this.loadFactor = loadFactor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
