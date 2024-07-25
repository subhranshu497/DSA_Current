package com.prep;

import java.util.*;

public class RevealCardsInIncreasingOrder {
    public static void main(String[] args) {
        int[] decks = {17,13,11,2,3,5,7};
        int [] result = revealCards(decks);
        for(int num : result) System.out.print(num+", ");
    }

    private static int[] revealCards(int[] decks) {
        Queue<Integer> dq = new LinkedList<>();
        int[] ans = new int[decks.length];
        Arrays.sort(decks);
        for(int i=0;i<decks.length;i++)dq.add(i);
        for(int i=0;i< decks.length;i++){
            int poll = dq.poll();
            ans[poll] = decks[i];
            int poll1 = dq.poll();
            dq.add(poll1);
        }
        return ans;
    }
}
