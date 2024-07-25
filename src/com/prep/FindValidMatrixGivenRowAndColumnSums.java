package com.prep;

public class FindValidMatrixGivenRowAndColumnSums {
    public static void main(String[] args) {
        int [] rowSum = {5,7,10};
        int [] colSum = {8,6,8};
        int[][] result = restoreMatrix(rowSum, colSum);
    }

    private static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int [][] res = new int[m][n];
        for(int i=0,j=0;i<m && j<n;){
            res[i][j]=Math.min(rowSum[i],colSum[j]);
            rowSum[i] -=res[i][j];
            colSum[j] -=res[i][j];
            i +=(rowSum[i] ==0?1:0);
            j +=(colSum[j] ==0?1:0);
        }
        return res;
    }
}
