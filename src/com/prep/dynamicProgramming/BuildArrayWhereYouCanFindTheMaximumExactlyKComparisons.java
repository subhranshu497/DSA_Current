package com.prep.dynamicProgramming;

import java.util.Arrays;

public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {
    private static int N;
    private static int M;
    private static int K;
    public static void main(String[] args) {
        int n = 50, m = 100, k = 25;
        int noOfArrays = numOfArrays(n,m,k);
        System.out.println(noOfArrays);
    }

    private static int numOfArrays(int n, int m, int k) {
        N =n;
        M=m;
        K=k;
        int [][][] memo = new int[N+1][K+1][M+1];
        for (int i = 0; i <N+1; i++) {
            for (int j = 0; j <K+1; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return numOfArraysSolve(0,0,0, memo);
    }

    private static int numOfArraysSolve(int idx, int searchCost, int maxValue, int [][][] memo) {
        int MOD = 1000000007;
        //base condition
        if(idx == N){
            if(searchCost==K){
                return 1;
            }
            return 0;
        }
        if(memo[idx][searchCost][maxValue] !=-1)return memo[idx][searchCost][maxValue];
        int result =0;
        for(int i=1;i<=M;i++){
            if(i>maxValue){
                result +=(numOfArraysSolve(idx+1,searchCost+1,i, memo))%MOD;
            }
            else{
                result +=(numOfArraysSolve(idx+1,searchCost,maxValue, memo))%MOD;
            }
        }
        return memo[idx][searchCost][maxValue] =result % MOD;
    }
}
