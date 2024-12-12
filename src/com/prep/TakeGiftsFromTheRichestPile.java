package com.prep;

import java.util.Collections;
import java.util.PriorityQueue;

public class TakeGiftsFromTheRichestPile {
    public static void main(String[] args) {
        int [] gifts = {25,64,9,4,100};
        int k = 4;
        long remain = pickGifts(gifts, k);
        System.out.println(remain);
    }

    private static long pickGifts(int[] gifts, int k) {
        long remains = 0l;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int gift:gifts){
            pq.offer(gift);
        }
        while(k !=0){
            int curr = pq.poll();
            int sq = (int) Math.sqrt(curr);
            pq.offer(sq);
            k--;
        }
        //iterrate pq for result
        while(!pq.isEmpty()){
            remains +=pq.poll();
        }
        return remains;
    }
}
