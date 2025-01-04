package com.prep.Backtracking1;

public class PathWithMaximumGold {
    private static int [][] directions ={{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        int [][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        int maxGold = getMaximumGold1(grid);
        System.out.println(maxGold);
    }

    private static int getMaximumGold1(int[][] grid) {
        int ans =Integer.MIN_VALUE;
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] !=0){
                    int count =0;
                    count = dfsGold1(grid, i,j,visited);
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }

    private static int dfsGold1(int[][] grid, int i, int j, boolean[][] visited) {
        //base condition
        if(i<0 || j<0 || i>= grid.length || j>=grid[0].length || grid[i][j]==0) return 0;
        int count=0;
        visited[i][j]=true;
        count +=grid[i][j];
        int up = dfsGold1(grid,i-1,j,visited);
        int down = dfsGold1(grid,i+1,j,visited);
        int left = dfsGold1(grid,i,j-1,visited);
        int right = dfsGold1(grid,i,j+1,visited);
        visited[i][j] = false;
        return count+= Math.max(Math.max(up,down),Math.max(right, left));
    }
}
