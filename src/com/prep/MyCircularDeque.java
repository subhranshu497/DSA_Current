package com.prep;

public class MyCircularDeque {
    private int k;
    private int[] deq;
    private int front;
    private int rear;
    private int currentSize;
    public MyCircularDeque(int k) {
        this.k = k;
        deq = new int[k];
        front =0;
        rear = k-1;
        currentSize = 0;
    }

    public boolean insertFront(int value) {
        if(!isFull()){
            front = (front-1+k)%k;
            deq[front] = value;
            currentSize++;
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if(!isFull()){
            rear = (rear+1)%k;
            deq[rear] = value;
            currentSize++;
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if(!isEmpty()){
            front = (front+1)%k;
            currentSize--;
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if(!isEmpty()){
            rear = (rear-1+k)%k;
            currentSize--;
            return true;
        }
        return false;
    }

    public int getFront() {
        if(!isEmpty()){
            return deq[front];
        }
        return -1;
    }

    public int getRear() {
        if(!isEmpty()){
            return deq[rear];
        }
        return -1;
    }

    public boolean isEmpty() {
        if(currentSize==0) return true;
        return false;
    }

    public boolean isFull() {
        if(currentSize==k) return true;
        return false;
    }
}
