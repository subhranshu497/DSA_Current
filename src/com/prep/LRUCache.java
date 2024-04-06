package com.prep;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node1 head;
    Node1 tail;
    int capacity;
    Map<Integer, Node1> cache;
    public LRUCache(int capacity) {
        capacity =2;
        cache  = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key){
        if(cache.containsKey(key)){
            Node1 node = cache.get(key);
            removeDLL(node);
            insertDLL(node);
            return node.val;
        }
        else return -1;
    }
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            removeDLL(cache.get(key));
        }
        if(cache.size()==capacity){
            removeDLL(tail.prev);
        }
        insertDLL(new Node1(key, value));
    }

    private void removeDLL(Node1 node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertDLL(Node1 node) {
        cache.put(node.key, node);
        Node1 headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;

    }
}
class Node1{
    int val;
    int key;
    Node1 prev;
    Node1 next;
    public Node1(int key, int val){
        this.key = key;
        this.val = val;
    }
}
