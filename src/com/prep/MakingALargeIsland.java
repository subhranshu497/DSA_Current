package com.prep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {

    private static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        int [][] grid = {{1,0},{0,1}};
        int maxArea = largestIsland(grid);
        System.out.println(maxArea);
    }

    private static int largestIsland(int[][] grid) {
        int n = grid.length;
        int maxArea = 0;
        boolean[][] visited = new boolean[n][n];
        int id =2;
        Map<Integer, Integer> map = new HashMap<>();// id of island - size of island
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int size = dfs1(grid, i,j,visited, id);
                    maxArea = Math.max(maxArea, size);
                    map.put(id, size);
                    id++;
                }
            }
        }

        //convert zeros and find maxArea

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    Set<Integer> set = new HashSet<>();
                    for(int [] direction:directions){
                        int i_ = i+direction[0];
                        int j_ = j+direction[1];
                        if(i_ >=0 && i_ <n && j_ >=0 && j_ <n && grid[i_][j_] !=0){
                            set.add(grid[i_][j_]);
                        }
                    }
                    int totalSize = 1; //o to 1
                    for(int idFromSet: set){
                        totalSize += map.getOrDefault(idFromSet,0);
                    }
                    maxArea = Math.max(maxArea, totalSize);
                }
            }
        }
        return maxArea;
    }

    private static int dfs1(int[][] grid, int i, int j, boolean[][] visited, int id) {
        //base condition
        if(i <0 || i>= grid.length || j<0 || j>= grid.length || visited[i][j] || grid[i][j]==0)
            return 0;
        visited[i][j] = true;
        grid[i][j]=id;
        int size =1;
        for(int [] direction :directions){
            int i_ = i+direction[0];
            int j_ = j+direction[1];

            size +=dfs1(grid, i_,j_,visited,id);
        }
        return size;
    }

    private static int largestIslandBruteForce(int[][] grid) {
        int n = grid.length;
        int maxArea = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    grid[i][j] =1;
                    boolean[][] visited = new boolean[n][n];
                    int largestArea = 0;
                    //call dfs to find out largest area
                    for(int k=0;k<n;k++){
                        for(int l=0;l<n;l++){
                            if(grid[k][l]==1 && !visited[k][l]){
                                largestArea = Math.max(largestArea, largestIslandDFS(grid, n, k, l, visited));
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, largestArea);
                    grid[i][j] =0;
                }
            }
        }
        return maxArea==0?n*n:maxArea;
    }

    private static int largestIslandDFS(int[][] grid, int n, int i, int j, boolean[][] visited) {
        //base condition
        if(i<0 || i>=n || j<0 || j>=n || visited[i][j] || grid[i][j]==0)
            return 0;
        visited[i][j] = true;
        int count = 1;
        for(int[] direction : directions){
            int i_ = i+direction[0];
            int j_ = j+direction[1];
            count +=largestIslandDFS(grid,n,i_,j_,visited);
        }
        return count;
    }
}
