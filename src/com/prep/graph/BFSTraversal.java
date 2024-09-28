package com.prep.graph;

import java.util.*;

public class BFSTraversal {
    public static void main(String[] args) {
        int [][] edges = {{1,2},{1,0},{0,2},{2,3},{2,4}};
        int n = 5;
        int e = 5;
        int source = 1;
        List<Integer> result = bfsTraversal(edges,n,e, source);
        for(int num:result) System.out.print(num+", ");
    }

    private static List<Integer> bfsTraversal(int[][] edges, int n, int e, int source) {
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[n];
        //prepare adj list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        System.out.println(adjList);
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i])simpleBFS(adjList, q,visited, n,i, result);
        }
     return result;
    }

    private static void simpleBFS(Map<Integer, List<Integer>> adjList, Queue<Integer> q, boolean[] visited, int n, int src, List<Integer> result) {
        q.add(src);
        visited[src]= true;
        result.add(src);
        while (!q.isEmpty()){
            int u = q.poll();
            for(int v : adjList.get(u)){
                if(!visited[v]){
                    visited[v]=true;
                    result.add(v);
                }
            }
        }
    }
}
