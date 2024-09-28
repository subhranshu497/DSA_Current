package com.prep.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DfsTraversal {
    public static void main(String[] args) {
        int [][] edges = {{1,2},{1,0},{0,2},{2,3},{2,4}};
        int n = 5;
        int e = 5;
        int source = 1;
        int [] result = dfsTraversal(edges,n,e, source);
        for(int num:result) System.out.print(num+", ");
    }

    private static int[] dfsTraversal(int[][] edges, int n, int e, int source) {
        //first create the adjacency List
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            if(!adjList.containsKey(u)) adjList.put(u, new ArrayList<>());
            adjList.get(u).add(v);
            if(!adjList.containsKey(v)) adjList.put(v, new ArrayList<>());
            adjList.get(v).add(u);
        }
        //print the adj list
        System.out.println(adjList);
        //do DFS for the traversal
        boolean [] visited = new boolean[n];
        int [] result = new int[n];
        List<Integer> list = new ArrayList<>();
        dfsForTraversal(adjList, visited, list, source);
        //convert list to array
        for(int i=0;i<n;i++) result[i]=list.get(i);
        return result;
    }

    private static void dfsForTraversal(Map<Integer, List<Integer>> adjList, boolean[] visited, List<Integer> list, int u) {
        //base condition
        if(visited[u])return;
        list.add(u);
        visited[u]=true;
        for(int v:adjList.get(u)){
            if(!visited[v]){
                dfsForTraversal(adjList,visited,list,v);
            }
        }
    }
}
