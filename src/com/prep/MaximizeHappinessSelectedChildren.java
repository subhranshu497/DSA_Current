package com.prep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeHappinessSelectedChildren {
    public static void main(String[] args) {
        int [] happiness = {12,1,42};
        int k =3;
        long happinessSum = maximumHappinessSum(happiness, k);
    }

    private static long maximumHappinessSumOptimized(int[] happiness, int k) {
        long happinessSum =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int happy:happiness)pq.add(happy);
        int count =0;
        for(int i=0;i<k;i++){
            happinessSum = Math.max(pq.poll()-count,0);
            count++;
        }
        return happinessSum;
    }

    private static long maximumHappinessSum(int[] happiness, int k) {
        long happinessSum =0;
        Arrays.sort(happiness);
        int counter =1;
        for(int i=happiness.length-1;i>=0;i--){
            happinessSum += happiness[i];
            if(i !=0 && happiness[i-1] !=0) {
                happiness[i-1] -= counter;
                if(happiness[i-1] <0)break;
            }
            else break;
            counter++;
            k--;
            if(k==0) break;
        }
        System.out.println(happinessSum);
        return happinessSum;
    }
}
