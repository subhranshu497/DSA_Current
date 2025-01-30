package com.prep;

import java.util.*;

public class GraphValidTree {
    public static void main(String[] args) {
        int [][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        int n = 5;
        System.out.println(validTree(n, edges));
    }

    private static boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        boolean[] visited = new boolean[n];
        //adj list prepare
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(u);
        }
        //it will be valid tree , if no cycle exists in the graph
        //when to handle cycle detection algo for disconnected graph , that time call this dfs inside a loop
        boolean flag = hasCycleDFS(adjList, visited, 0, -1);

        if(flag)
            return false;
        else{
            for(boolean f:visited)
                if(!f) return false;
        }
        return true;
    }

    private static boolean hasCycleDFS(Map<Integer, List<Integer>> adjList, boolean[] visited, int u, int parent) {
        //mark visited
        visited[u] = true;
        for(int v:adjList.getOrDefault(u, Collections.emptyList())){
            if(v==parent)
                continue;
            if(visited[v])
                return true;
            if(hasCycleDFS(adjList, visited,v,u))
                return true;
        }
return false;
    }

//    private static boolean validTree(int n, int[][] edges) {
//        Map<Integer, List<Integer>> adjList = new HashMap<>();
//        for(int[] edge:edges){
//            int u = edge[0];
//            int v = edge[1];
//            if(!adjList.containsKey(u)){
//                adjList.put(u, new ArrayList<>());
//                adjList.get(u).add(v);
//                adjList.putIfAbsent(v, new ArrayList<>());
//                adjList.get(v).add(u);
//            }else{
//                if(adjList.containsKey(v))
//                    return false;
//                else {
//                    adjList.put(v, new ArrayList<>());
//                    adjList.get(v).add(u);
//                }
//            }
//        }
//        return true;
//    }
}
