package com.prep;

public class CountServersThatCommunicate {
    public static void main(String[] args) {
        int [][] grid = {{1,0},{0,1}};
        int count = countServers(grid);
        System.out.println(count);
    }

    private static int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [] rowCount = new int[m];
        int [] colCount = new int[n];

        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(grid[i][j] !=0) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int count =0;
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1) {
                    if(rowCount[i]>1 || colCount[j]>1)count++;
                }
            }
        }
        return count;
    }
}
