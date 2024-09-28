package com.prep;

public class Convert1DArrayInto2DArray {
    public static void main(String[] args) {
        int [] original = {1,2,3,4};
        int m =2;
        int n=2;
        int [][] result = constructTwoDArray(original, m,n);
        //print 2d array
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(result[i][j]+"     ");
            }
            System.out.println();
        }
    }

    private static int[][] constructTwoDArray(int[] original, int m, int n) {
        int len = original.length;
        if(len !=m*n) return new int[0][0];
        int[][] result = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result[i][j]=original[i*n+j];
            }
        }
        return result;
    }
}
