package com.prep.recursion;

import java.util.Arrays;

public class UniquePath {
    public static void main(String[] args) {
        int m = 3;
        int n =7;
        int [][] memo = new int[m][n];
        for(int [] arr:memo) Arrays.fill(arr, -1);
        int paths = uniquePaths(0,0,m,n, memo);
        System.out.println(paths);
    }

    private static int uniquePaths(int i, int j, int m, int n, int [][] memo) {
        //base contion
        if(i==m-1 && j==n-1) return 1;
        // boundary condition
        if(i < 0 || i >= m || j < 0 || j >= n)return 0;
        if(memo[i][j] !=-1) return memo[i][j];
        int right = uniquePaths(i,j+1, m,n, memo);
        int down = uniquePaths(i+1, j,m,n, memo);

        return memo [i][j]= right+down;
    }
}
