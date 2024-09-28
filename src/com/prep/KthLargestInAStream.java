package com.prep;

import java.util.PriorityQueue;

public class KthLargestInAStream {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    int[] nums;
    public KthLargestInAStream(int k, int[] nums) {
        this.k = k;
        int large=Integer.MIN_VALUE;
        int i=0;
        while(i<nums.length){
            if(pq.size()<k){
                pq.offer(nums[i]);
            }
            else if(nums[i]>pq.peek()){
                pq.offer(nums[i]);
                if(pq.size()>k)pq.poll();
            }
            i++;
        }
    }
    public int add(int val) {
        if(pq.size()<k){
            pq.offer(val);
        }
        else if(val>pq.peek()){
            pq.offer(val);
            pq.poll();
        }
        return pq.peek();
    }
    public int findKthLargest(int [] nums, int k){
        int large=Integer.MIN_VALUE;
        int i=0;
        while(i<nums.length){
            if(pq.size()<k){
                pq.offer(nums[i]);
            }
            else if(nums[i]>pq.peek()){
                pq.offer(nums[i]);
                if(pq.size()>k)pq.poll();
            }
            i++;
        }
        return pq.peek();
    }
}
