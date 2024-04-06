package com.prep;

import java.math.BigInteger;
import java.util.PriorityQueue;

public class FindKthLargestIntegerInTheArray {
    public static void main(String[] args) {
        String [] nums = {"3","6","7","10"};
        int k = 4;
        System.out.println(findKthLargestInteger(nums, k));
    }

    private static String findKthLargestInteger(String[] nums, int k) {
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(new BigInteger(nums[i]));
        }
        for(int i=k;i<nums.length;i++){
            BigInteger bi = new BigInteger(nums[i]);
            if(bi.compareTo(pq.peek())==1){
                pq.poll();
                pq.add(new BigInteger(nums[i]));
            }
        }
        return pq.peek()+"";
    }
}
