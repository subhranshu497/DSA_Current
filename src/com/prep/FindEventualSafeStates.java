package com.prep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {
    public static void main(String[] args) {
        int [][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> safeNodes = eventualSafeNodes(graph);
        System.out.println(safeNodes);
    }

    // Kahn's Algo
    // first reverse it and apply bfs
    private static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        int [] indegree = new int[n];
        // reverse the graph
        for(int u=0;u<n;u++){
            adj.add(new ArrayList<>());
        }
        for(int u=0;u<n;u++){
            for(int v:graph[u]){
                adj.get(v).add(u);
                indegree[u]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        // add all the nodes whose indegree is zero
        for(int i=0;i<n;i++){
            if(indegree[i] ==0)
                q.add(i);
        }
        boolean [] isSafe = new boolean[n];
        //traverse the queue and collect all the nodes whose indegree can be zero on poll
        while (!q.isEmpty()){
            int u = q.poll();
            isSafe[u]= true;
            for(int v:adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isSafe[i])
                safeNodes.add(i);
        }
        return safeNodes;
    }
}
