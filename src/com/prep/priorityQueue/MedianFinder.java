package com.prep.priorityQueue;

import java.util.PriorityQueue;

public class MedianFinder {
    //take two priority queue - left max heap and right min heap
    //always maintain the size diff between two heap should not be greater than one
    //if any time size diff is greater than one , then shift an element from right min heap to left max heap
    //if both pq has same size , then median = (leftPq.peek + rightpq.peek )/2
    // else median = leftpq.peek

    PriorityQueue<Integer> left_MaxHeap;
    PriorityQueue<Integer> right_MinHeap;
    public MedianFinder() {
        left_MaxHeap = new PriorityQueue<>((a,b)->b-a);
        right_MinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(left_MaxHeap.isEmpty() || num < left_MaxHeap.peek()){
            left_MaxHeap.add(num);
        }
        else{
            right_MinHeap.add(num);
        }
        //balancing
        if(Math.abs(left_MaxHeap.size()-right_MinHeap.size()) >1){
            right_MinHeap.add(left_MaxHeap.poll());
        }
        else if(left_MaxHeap.size() < right_MinHeap.size()){
            left_MaxHeap.add(right_MinHeap.poll());
        }
    }

    public double findMedian() {
        if(left_MaxHeap.size()==right_MinHeap.size()){
            return (left_MaxHeap.peek()+right_MinHeap.peek())/2.0;
        }
        else return left_MaxHeap.peek();
    }
}
