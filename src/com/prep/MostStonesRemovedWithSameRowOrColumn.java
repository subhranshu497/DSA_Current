package com.prep;

import java.util.Arrays;

public class MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {
        int [][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        int removed = removedStones(stones);
        System.out.println(removed);
    }

    private static int removedStones(int[][] stones) {
        int n = stones.length;
        boolean [] visited = new boolean[n];
        Arrays.fill(visited, false);
        int group =0;
        for(int i=0;i<n;i++){
            if(visited[i])continue;
            removedStonesDFS(stones, visited,n,i);
            group++;
        }
        return (n-group);
    }

    private static void removedStonesDFS(int[][] stones, boolean[] visited, int n, int index) {
        visited[index] = true;
        int r = stones[index][0];
        int c = stones[index][1];
        for(int i=0;i<n;i++){
            if(!visited[i] && (stones[i][0]==r || stones[i][1]==c))removedStonesDFS(stones, visited,n,i);
        }
    }
}
