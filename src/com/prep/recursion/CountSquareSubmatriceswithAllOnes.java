package com.prep.recursion;

import java.util.Arrays;

public class CountSquareSubmatriceswithAllOnes {
    public static void main(String[] args) {
        int [][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        int count = countSqSubMatUsingDP(matrix);
        System.out.println(count);
    }

    private static int countSqSubMatUsingDP(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dp = new int[m][n];
        int result = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0) dp[i][j] = matrix[i][j];
                else if(matrix[i][j]==1){
                    int temp  =  Math.min(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = 1+ Math.min(temp, dp[i-1][j-1]);
                }
                result +=dp[i][j];
            }
        }

        return result;
    }

    private static int countSqSubMat(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] memo = new int[m][n];
        for(int [] arr:memo){
            Arrays.fill(arr,-1);
        }
        int count =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1)
                    count += solveMat(matrix, i,j,m,n, memo);
            }
        }
        return count;
    }

    private static int solveMat(int[][] matrix, int i, int j, int m, int n, int [][] memo) {
        //base condition
        if(i>=m || j>=n) return 0;
        if(matrix[i][j] == 0) return 0;
        if(memo[i][j] !=-1) return memo[i][j];

        int right = solveMat(matrix, i,j+1,m,n,memo);
        int below = solveMat(matrix, i+1,j,m,n, memo);
        int diagonal = solveMat(matrix, i+1,j+1,m,n, memo);
        int temp = Math.min(right, below);
        return memo[i][j]= 1+Math.min(temp, diagonal);
    }
}
