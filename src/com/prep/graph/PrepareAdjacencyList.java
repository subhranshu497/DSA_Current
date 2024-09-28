package com.prep.graph;

import java.util.*;

public class PrepareAdjacencyList {
    public static void main(String[] args) {
        int n =2;
        int [][] prerequisites={{1,0}, {0,1}};
        Map<Integer, List<Integer>> adjList = prepareAdjList(prerequisites, n);
        System.out.println(adjList);
    }

    private static Map<Integer, List<Integer>> prepareAdjList(int[][] prerequisites, int n) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] arr :prerequisites){
            int u =arr[0];
            int v =arr[1];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }
}
