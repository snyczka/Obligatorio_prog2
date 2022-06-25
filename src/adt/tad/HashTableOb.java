package adt.tad;

import exeptions.InvalidKey;
import exeptions.NonExistantElement;

public class HashTableOb<K, T> implements HashOb<K, T>{
    private static final int initialSize = 10;
    private HashNodeOb<K, T>[] hashArray;
    private float loadFactor = 0.8f;
    private int size;
    private int arraySize;
    private ArrayListOb<K> keys;



    public HashTableOb(Class<K> key){
        this.hashArray = new HashNodeOb[initialSize];
        this.arraySize = initialSize;
        this.size = 0;
        this.keys = new ArrayListOb(key);
    }

    private HashTableOb(int size){
        this.hashArray = new HashNodeOb[size];
        this.arraySize = size;
        this.size = 0;
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
            this.keys.add(key);
            this.setSize(this.getSize() + 1);
        if ((float) this.getSize()/this.getHashArray().length >= loadFactor){
            int newSize = this.getHashArray().length * 10;
            HashTableOb<K, T> newHash = new HashTableOb<K, T>(newSize);
            newHash.setKeys(this.keys);
            for(int i = 0; i < this.getSize(); i++){
                try {
                    newHash.put(this.getKeys().get(i),this.get(this.getKeys().get(i)));
                } catch (NonExistantElement e) {
                    e.printStackTrace();
                }
            }
            this.setHashArray(newHash.getHashArray());
            this.arraySize = newSize;
        }
    }

    private int collisionHelper(K key, int position){
        int newPosition;
        if(position == this.getHashArray().length-1){
            newPosition = 0;
        }else{
            newPosition = position++;
        }
        int counter = this.getHashArray().length;
        while (counter < 0){
            if(this.getHashArray()[newPosition] != null && !this.getHashArray()[newPosition].isDeleted()){
                counter = 1;
            }else if (newPosition == this.getHashArray().length -1){
                newPosition = 0;
            }else {
                newPosition = newPosition++;
            }
            counter--;
        }


        return newPosition;
    }

    @Override
    public T get(K key) {
        T result = null;
        int counter = 0;
        int position = hash(key);
        if (this.getHashArray()[position] == null){
            return null;
        }else if(this.getHashArray()[position].getKey().equals(key) && !this.getHashArray()[position].isDeleted()){
            result = this.getHashArray()[position].getData();
        }else {
            do {
                if(position == this.getHashArray().length-1){
                    position = 0;
                }else {
                    position++;
                }
                counter++;
            }while (counter < this.getHashArray().length-1 && this.getHashArray()[position] != null &&
                    (!(this.getHashArray()[position].getKey().equals(key) && !this.getHashArray()[position].isDeleted())
            || (!this.getHashArray()[position].getKey().equals(key) && this.getHashArray()[position].isDeleted())));
            if(this.getHashArray()[position] != null && this.getHashArray()[position].getKey().equals(key) && !getHashArray()[position].isDeleted()){
                result =this.getHashArray()[position].getData();
            }
        }

        if (result == null){
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
            return ((int)key) % this.arraySize;
        }else if(key instanceof Long){
            return ((Long) key).intValue() % this.arraySize;

        }else if(key instanceof String){
                return (((String) key).length() * 17) %this.arraySize;
        }else{
            return key.toString().length()%this.arraySize; //Se asume que cualquier K tendrá su método de string reescrito de ser necesario
        }
    }

    public ArrayListOb<K> getKeys() {
        return keys;
    }

    public void setKeys(ArrayListOb<K> keys) {
        this.keys = keys;
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
