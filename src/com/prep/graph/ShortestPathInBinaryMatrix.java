package com.prep.graph;

import java.util.*;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int [][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        int path = shortestPathUsingDijkstra(grid);
        System.out.println(path);
    }
    private static int shortestPathUsingDijkstra(int [][] grid){
        //for traversing we can use directions array
        int [][] directions = {{1,1},{1,-1},{-1,1},{1,0},{0,1},{0,-1},{-1,0},{-1,-1}};
        int m = grid.length;
        int n = grid[0].length;
        int [][] result = new int[m][n];
        // fill result matrix wth max value
        for(int [] row:result){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        //base condition
        if(m ==0 && n ==0 && grid[0][0] !=0) return -1;
        //pq of distance and corodinates
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(p->p.first));
        pq.add(new Pair(0, new Pair(0,0)));
        result[0][0] = 1;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int dist = pair.first;
            int x = pair.p.first;
            int y = pair.p.second;
            for(int [] direction:directions){
                int newX = x+direction[0];
                int newY = y+direction[1];
                int d = 1;
                if(isSafe(newX, newY, m, n)&& grid[newX][newY]==0 && d+dist <result[newX][newY]){
                    grid[newX][newY] =1;
                    result[newX][newY] = d+dist;
                    pq.add(new Pair(d+dist, new Pair(newX, newY)));
                }
            }
        }
        if(result[m-1][n-1]==Integer.MAX_VALUE) return -1;
        return result[m-1][n-1]+1;
    }

    //source is (0,0) destination is (m-1, n-1)
    private static int shortestPathUsingBFS(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m==0 || n==0 || grid[0][0] !=0) return -1;
        //construct the direction array
        int [][] directions = {{0,1},{0,-1},{-1,0},{1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        grid[0][0] =1;
        int level =0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size !=0){
                Pair current = q.poll();
                int x = current.first;
                int y = current.second;
                //base condition
                if(x==m-1 && y==n-1) return level+1;
                // traverse in the dir
                for(int [] direction:directions){
                    int newX = x+direction[0];
                    int newY = y+direction[1];
                    if(isSafe(newX, newY,m,n) && grid[newX][newY]==0){
                        q.add(new Pair(newX, newY));
                        grid[newX][newY]=1;
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }

    private static boolean isSafe(int x, int y, int m, int n) {
        return x >=0 && y >=0 && x<m && y<n;
    }

    static class Pair{
        int first;
        int second;
        Pair p;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
        Pair(int first, Pair p){
            this.first = first;
            this.p = p;
        }
    }
}
