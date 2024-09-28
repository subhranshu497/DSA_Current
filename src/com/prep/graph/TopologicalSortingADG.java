package com.prep.graph;

import java.util.*;

public class TopologicalSortingADG {
    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0,3));
        edges.add(Arrays.asList(3,1));
        edges.add(Arrays.asList(1,4));
        edges.add(Arrays.asList(5,4));
        edges.add(Arrays.asList(5,1));
        edges.add(Arrays.asList(2,1));
        edges.add(Arrays.asList(2,3));
        edges.add(Arrays.asList(0,2));
        int vertics = 6;
        List<Integer> result = topoSort(edges, vertics);
        System.out.println(result);
    }

    private static List<Integer> topoSort(List<List<Integer>> edges, int vertics) {
        //adjacency List
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(List<Integer> edge:edges){
            int u=edge.get(0);
            int v = edge.get(1);
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v,new ArrayList<>());
            adjList.get(u).add(v);

        }
        //start DFS
        boolean [] visited = new boolean[vertics];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<vertics;i++){
            if(!visited[i]) topoSortDFS(adjList, visited, i, st);
        }
        List<Integer> result = new ArrayList<>();
        while(!st.isEmpty()){
            result.add(st.pop());
        }
        return result;
    }

    private static void topoSortDFS(Map<Integer, List<Integer>> adjList, boolean[] visited, int u, Stack<Integer> st) {
        visited[u]=true;
        for(int v:adjList.get(u)){
            if(!visited[v])topoSortDFS(adjList, visited,v,st);
        }
        st.push(u);
    }
}
