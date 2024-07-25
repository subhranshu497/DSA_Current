package com.prep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllAncestorsOfNodeDirectedAcyclicGraph {
    public static void main(String[] args) {
        int n=8;
        int [][]edgeList={{0,3},{0,4},{1,3}};
        List<List<Integer>> results = getAncestors(n, edgeList);
    }

    private static List<List<Integer>> getAncestors(int n, int[][] edgeList) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] adjList = new ArrayList[n];
        for(int i=0;i<n;i++){
            adjList[i]= new ArrayList<>();
        }
        for(int[] edge :edgeList){
            int from = edge[0];
            int to = edge[1];
            adjList[to].add(from);
        }
        for(int i=0;i<n;i++){
            List<Integer> anstr = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
           // findChildren
        }
        return new ArrayList<>();
    }
}
