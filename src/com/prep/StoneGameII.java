package com.prep;

import java.util.Arrays;

public class StoneGameII {
    private static int [][][] dp = new int[2][101][101];
    public static void main(String[] args) {
        int[] piles = {2,7,9,4,4};
        int stone = stoneGmaeTwo(piles);
        System.out.println(stone);
    }

    private static int stoneGmaeTwo(int[] piles) {
        int n = piles.length;
        int M=1;
        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }
        int result = solveForAlice(1,0,M,n, piles);
        return result;
    }

    private static int solveForAlice(int person, int i, int m, int n, int[] piles) {
        if(i>=n)return 0;
        if(dp[person][i][m] !=-1) return dp[person][i][m];
        int stones =0;
        int result = person==1?-1:Integer.MAX_VALUE;
        for(int x=1;x<=Math.min(2*m, n-i);x++){
            stones +=piles[i+x-1];
            if(person ==1){ //Alice
                result = Math.max(result, stones+solveForAlice(0,i+x, Math.max(m,x),n,piles));
            }
            else{ //Bob
                result =Math.min(result, solveForAlice(1, i+x,Math.max(m,x),n,piles));
            }
        }
        return dp[person][i][m]=result;
    }
}


