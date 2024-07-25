package com.prep;

import java.util.Arrays;

public class FreedomTrails {
    public static void main(String[] args) {
        String ring = "godding";
        String key = "gd";
        System.out.println(findRotateTrails(ring, key));
    }

    private static int findRotateTrails(String ring, String key) {
        int ptr =0;
        int index =0;
        return solveTrails(ring, key, ptr, index);
    }

    private static int solveTrails(String ring, String key, int ptr, int index) {
        int steps = Integer.MAX_VALUE;
        int n = ring.length();
        int m = key.length();
        int [][]dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        if(dp[index][ptr]==-1) return dp[index][ptr];
        for(int i=0;i<n;i++){
            if(ring.charAt(i)==key.charAt(index)){
                int absVal = Math.abs(i-ptr);
                steps = Math.min(steps, Math.min(n-absVal,absVal))+1+solveTrails(ring,key,i,index+1);
            }
        }
        return dp[index][ptr]=steps;
    }
}
