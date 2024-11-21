package com.prep;

public class CountUnguardedCellsInTheGrid {
    public static void main(String[] args) {
        int[][] guards = {{0,0},{1,1},{2,3}};
        int[][] walls = {{0,1},{2,2},{1,4}};
        int m =4;
        int n =7;
        int unguardedCells = countUnguarded(m,n,guards,walls);
        System.out.println(unguardedCells);
    }

    private static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int [][] grid = new int[m][n];
        //fill the grid , 2 = wall and 3 = guard
        for(int[] wall:walls){
            int wallX = wall[0];
            int wallY = wall[1];
            grid[wallX][wallY] =2;
        }
        for(int[] guard:guards){
            int guardX = guard[0];
            int guardY = guard[1];
            grid[guardX][guardY] =3;
        }
        for(int g[]:guards){
            int gx = g[0];
            int gy = g[1];
            dfsGuard(grid, gx-1, gy, m,n,1);
            dfsGuard(grid, gx+1, gy, m,n,2);
            dfsGuard(grid, gx, gy-1, m,n,3);
            dfsGuard(grid, gx, gy+1, m,n,4);
        }
        int ans =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)
                    ans++;
            }
        }
        return ans;
    }

    private static void dfsGuard(int[][] grid, int i, int j, int m, int n, int direction) {
        //base condition
        if(i<0 || j>=n || i>=m || j<0 || grid[i][j]==2 || grid[i][j]==3)
            return;
        grid[i][j] =1;
        if(direction==1)
            dfsGuard(grid,i-1,j,m,n,direction); // up
        else if(direction==2)
            dfsGuard(grid,i+1,j,m,n,direction); // down
        else if(direction==3)
            dfsGuard(grid,i,j-1,m,n,direction); // left
        else if(direction==4)
            dfsGuard(grid,i,j+1,m,n,direction); // right

    }
}
