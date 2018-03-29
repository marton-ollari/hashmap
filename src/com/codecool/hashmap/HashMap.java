package com.codecool.hashmap;

import exceptions.KeyAlreadyExistsException;
import exceptions.KeyNotFoundException;

import java.util.LinkedList;

public class HashMap {
        private int bucketSize = 16;
        private LinkedList<KeyValue>[] elements = new LinkedList[bucketSize];

        public void add(String key, Integer value) {
            int position = getHash(key);
            LinkedList list = elements[position];
            if (keyIsUsed(key, list)){
                throw new KeyAlreadyExistsException();
            }
            if (list == null){
                list = new LinkedList();
                list.add(new KeyValue(key,value));
                elements[position] = list;
            } else {
                list.add(new KeyValue(key, value));
            }
            //resizeIfNeeded();
        }

        private boolean keyIsUsed(String key, LinkedList<KeyValue> list) {
            if (list != null){
                for (KeyValue keyValue: list){
                    if ( keyValue.getKey().equals(key)){
                        return true;
                    }
                }
            }
            return false;
        }

        public Integer getValue(String key) {
            int hash = key.hashCode() % bucketSize;
            LinkedList<KeyValue> list = elements[hash];
            for (KeyValue keyValue: list){
                if (keyValue.getKey().equals(key)){
                    return keyValue.getValue();
                }
            }
            throw new KeyNotFoundException();
        }

        public void remove(String key) {
            int hash = key.hashCode() % bucketSize;
            LinkedList<KeyValue> list = elements[hash];
            for (int i=0; i<list.size(); i++){
                if (list.get(i).getKey().equals(key)){
                    list.remove(i);
                    return;
                }
            }
            throw new KeyNotFoundException();
        }

        public void clearAll() {
            elements = new LinkedList[bucketSize];
        }

        private int getHash(String  key) {
            return key.hashCode() % bucketSize;
        }

        private void resizeIfNeeded(){
    }

    @Override
    public String toString() {
        String returnString = "HashMap: ";
        for (int i=0; i<bucketSize; i++){
            returnString += i + ": ";
            if (elements[i] != null){
                for (KeyValue keyValue : elements[i]){
                    returnString += keyValue.getKey() + " " + keyValue.getValue() + " ";
                }

            }
        };
        return returnString;
    }

    // + other functions, like clearAll(), delete(),..

}
