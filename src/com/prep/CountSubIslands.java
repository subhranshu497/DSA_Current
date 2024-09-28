package com.prep;

public class CountSubIslands {
    private static boolean flag;
    public static void main(String[] args) {
        int [][] grid1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int [][] grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        int count = countSubIslands(grid1, grid2);
        System.out.println(count);
    }

    private static int countSubIslands(int[][] grid1, int[][] grid2) {
        int count=0;
        for(int i=0;i<grid2.length;i++){
            for(int j=0;j<grid2[0].length;j++){
                if(grid2[i][j]==1){
                    flag =true;
                    bfsCountSubIsland(grid1, grid2, i, j);
                    if(flag)count++;
                }
            }
        }
        return count;
    }

    private static void bfsCountSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
        //base condition
        if(i<0 || j<0 || i>= grid2.length || j>=grid2[0].length) return;
        if(grid2[i][j]==0) return;
        if(grid1[i][j]==0) flag =false;
        grid2[i][j]=0;
        bfsCountSubIsland(grid1, grid2,i+1,j);
        bfsCountSubIsland(grid1, grid2,i-1,j);
        bfsCountSubIsland(grid1, grid2,i,j+1);
        bfsCountSubIsland(grid1, grid2,i,j-1);
    }
}

