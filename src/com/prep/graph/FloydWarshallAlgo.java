package com.prep.graph;

public class FloydWarshallAlgo {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 43},{1, 0, 6},{-1, -1, 0}};
        int [][] result = floydWarShallImpl(grid);
        //printing the 2d matrix
        for(int i=0;i< result.length;i++){
            for(int j=0;j< result.length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
    //to calculate shortest distance from each node

    private static int[][] floydWarShallImpl(int[][] grid) {
        //-1 means no edges
        //for the simplicity of calculation first change the -1 with the max value
        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid.length;j++){
                if(grid[i][j]==-1)grid[i][j]=100000;
            }
        }
        //traverse the node via each node
        // if the distance via node is less then update the distance
        for(int k=0;k< grid.length;k++){
            for(int i=0;i< grid.length;i++){
                for(int j=0;j< grid.length;j++){
                    grid[i][j]=Math.min(grid[i][j],grid[i][k]+grid[k][j]);
                }
            }
        }
        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid.length;j++){
                if(grid[i][j]==100000)grid[i][j]=-1;
            }
        }
        return grid;
    }
}
