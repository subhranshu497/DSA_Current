package com.prep.priorityQueue;

import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {
    public static void main(String[] args) {
        int [] piles = {5,4,9};
        int k = 2;
        int ops = minStoneSum(piles, k);
        System.out.println(ops);
    }

    private static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        // add all to the pq
        for(int pile:piles){
            pq.add(pile);
        }
        // do the operation
        while(k>0){
            int top = pq.poll();
            top = Math.ceilDiv(top, 2);
            pq.add(top);
            k--;
        }
        //calculate sum
        int result = 0;
        while(!pq.isEmpty()){
            result +=pq.poll();
        }
        return result;
    }
}
