package com.prep;

import java.util.PriorityQueue;

public class HandOfStraights {
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize=3;
        boolean result = isStraightHand(hand,groupSize);
        System.out.println(result);
    }

    private static boolean isStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize !=0) return false;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<hand.length;i++){
            pq.add(hand[i]);
        }
        while (!pq.isEmpty()){
            int smallest = pq.poll();
            for(int i=1;i<groupSize;i++){
                if(pq.remove(smallest+i))continue;
                else return false;
            }
        }
        return true;
    }
}
