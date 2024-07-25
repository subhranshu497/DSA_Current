package com.prep;

import java.util.Arrays;

public class MostProfitAssigningWork {
    public static void main(String[] args) {
        int [] worker = {4,5,6,7};
        int [] profit = {10,20,30,40,50};
        int [] difficulty = {2,4,6,8,10};
        int maxProfit = maxProfitAssignment(worker, profit, difficulty);
    }

    private static int maxProfitAssignment(int[] worker, int[] profit, int[] difficulty) {
        int maxProfit =0;
        int[][] jobProfile = new int[difficulty.length][2];
        for(int i=0;i<difficulty.length;i++){
            jobProfile[i][0]=difficulty[i];
            jobProfile[i][1]=profit[i];
        }
        Arrays.sort(jobProfile,(a,b)->a[0]-b[0]);
        Arrays.sort(worker);
        int j=0;
        int tempProfit=0;
        for(int i=0;i< worker.length;i++){
            int ability = worker[i];
            while (j< jobProfile.length && ability>=jobProfile[j][0]){
                tempProfit = Math.max(tempProfit, jobProfile[j][1]);
                j++;
            }
            maxProfit +=tempProfit;
        }
        System.out.println(maxProfit);
        return maxProfit;
    }
}
