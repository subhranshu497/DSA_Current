package com.prep.leetcode150.graphGeneral;

import java.util.LinkedList;
import java.util.Queue;

public class LNum200NumberOfIsland {
    //parent and rank array only be useful for union find
    // count number of island using DSU , is yet to be worked. Its not correct
    static int [] parent;
    static int [] rank;
    public static void main(String[] args) {
        char [][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        //int islandCount = numIslandsUsingDFS(grid);
        parent = new int[grid.length];
        rank = new int[grid.length];
        //initialize parent and rank
        for(int i=0;i<grid.length;i++){
            parent[i]=i;
            rank[i] =1;
        }
        //int islandCount = numIslandUsingUnionFind(grid);
        int islandCount = numIslandUsingBFS(grid);
        System.out.println(islandCount);
    }

    private static int numIslandUsingBFS(char[][] grid) {
        int count=0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    countIslandBFS(grid, i, j , m ,n);
                    count++;
                }
            }
        }
        return count;
    }
    private static void countIslandBFS(char [][] grid, int i, int j, int m, int n){
        //mark visited
        grid[i][j]=0;
        Queue<Integer> q = new LinkedList<>();
        int itemTobeTraversed = i*n+j;
        q.offer(itemTobeTraversed);
        while (!q.isEmpty()){
            itemTobeTraversed = q.poll();
            int x = itemTobeTraversed /i;
            int y = itemTobeTraversed %j;
            //traversed up
            if(x>0 && grid[x-1][y]=='1'){
                //yet to be implemented
            }
        }
    }

    private static int numIslandUsingUnionFind(char[][] grid) {
        int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int count=0;
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    for(int[] dir:directions){
                        int x = i+dir[0];
                        int y = j+dir[1];
                        if(x< grid.length && x>=0 && y< grid[0].length && y>=0 && grid[x][y]==1){
                            int a = i*grid[0].length+j;
                            int b = x*grid[0].length+y;
                            union(a,b);
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    private static int numIslandsUsingDFS(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    countIslandDFS(grid, m,n,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void countIslandDFS(char[][] grid, int m, int n, int i, int j) {
        //base condition
        if(i>=m || i<0 || j>=n || j<0 || grid[i][j] !='1') return;
        //mark visited
        grid[i][j]='2';
        countIslandDFS(grid,m,n,i+1,j);
        countIslandDFS(grid,m,n,i,j-1);
        countIslandDFS(grid,m,n,i-1,j);
        countIslandDFS(grid,m,n,i,j+1);
    }
    //using union find
    private static int find(int x){
        if(parent[x] == x) return x;
        return parent[x]= find(parent[x]);
    }
    private static void union(int x, int y){
        int xParent = find(x);
        int yParent = find(y);
        if(xParent==yParent)return;
        if(rank[xParent] >rank[yParent]){
            parent[yParent] = xParent;
        }
        else if(rank[xParent] < rank[yParent]){
            parent[xParent] = yParent;
        }
        else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
}
