package com.prep.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int [][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        int minPath = minimumEffortPath(heights);
        System.out.println(minPath);
    }

    private static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] result = new int[m][n];
        for(int [] r:result){
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        int [][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(p->p.first));
        pq.add(new Pair(0, new int[]{0,0}));
        result[0][0]=0;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int diff = pair.first;
            int[] cordinates = pair.cordinates;
            int x = cordinates[0];
            int y = cordinates[1];
            if(x==m-1 && y==n-1) return diff;
            for(int [] direction:directions){
                int newX = x+direction[0];
                int newY = y+direction[1];
                if(isSafepath(newX, newY, m,n)){
                    int absdiff = Math.abs(heights[newX][newY]-heights[x][y]);
                    int effort = Math.max(absdiff, diff);
                    if(effort < result[newX][newY]){
                        result[newX][newY] = effort;
                        pq.add(new Pair(effort, new int[]{newX, newY}));
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
        return result[m-1][n-1];
    }

    private static boolean isSafepath(int x, int y, int m, int n) {
        return x<m && y<n && x >=0 && y>=0;
    }

    static class Pair{
        int first;
        int second;
        int[] cordinates;
        Pair(int first, int[] cordinates){
            this.first = first;
            this.cordinates = cordinates.clone();
        }
    }
}
