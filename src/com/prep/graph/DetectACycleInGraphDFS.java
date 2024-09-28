package com.prep.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectACycleInGraphDFS {
    public static void main(String[] args) {
        int [][] edges = {{0,1},{1,2},{2,3},{3,4},{1,4}};
        int V = 5;
        boolean cycle = isCyclic(edges, V);
        System.out.println(cycle);
    }

    private static boolean isCyclic(int[][] edges, int vertices) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        boolean [] visited = new boolean[vertices];
       //create adj list
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        for(int i=0;i<vertices;i++){
            if(!visited[i] && cycleDFS(adjList, visited, 0, -1)) return true;
        }
        return false;
    }

    private static boolean cycleDFS(Map<Integer, List<Integer>> adjList, boolean[] visited, int u, int parent) {
        visited[u] = true;
        for(int v:adjList.get(u)){
            if(v==parent) continue;
            if(visited[v]) return true;
            if(cycleDFS(adjList, visited,v,u)) return true;
        }
        return false;
    }


}
