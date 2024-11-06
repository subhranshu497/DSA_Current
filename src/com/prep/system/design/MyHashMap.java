package com.prep.system.design;

import java.util.LinkedList;
import java.util.List;

public class MyHashMap {
    private int size = 10000;
    private List<Pair>[] bucket;

    public MyHashMap() {
        bucket = new LinkedList[size];
        for(int i = 0;i<size;i++){
            bucket[i] = new LinkedList<>();
        }
    }
    public void put(int key, int value) {
        int bucketNo = key % size;
        List<Pair> chain = bucket[bucketNo];
        for(Pair item :chain){
            if(item.key==key){
                item.value = value;
                return;
            }
        }
        chain.addLast(new Pair(key, value));
    }
    public int get(int key) {
        int bucketNo = key % size;
        List<Pair> chain = bucket[bucketNo];
        for(Pair p:chain){
            if(p.key == key) return p.value;
        }
        return -1;
    }

    public void remove(int key) {
        int bucketNo = key % size;
        List<Pair> chain = bucket[bucketNo];
        for(Pair p :chain){
            if(p.key == key){
                chain.remove(p);
                return;
            }
        }
    }
    class Pair{
        int key;
        int value;
        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
