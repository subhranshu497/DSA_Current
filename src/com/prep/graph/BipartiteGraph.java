package com.prep.graph;

import java.util.*;

public class BipartiteGraph {
    public static void main(String[] args) {
        int [][] edges = {{1,2},{1,3},{2,3}};
        int vertices = 3;
        boolean flag = isBipartite(edges, vertices);
        System.out.println(flag);
    }

    private static boolean isBipartite(int[][] edges, int vertices) {
        //create adj list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] edge:edges){
            int u=edge[0];
            int v = edge[1];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int balck = 0;
        int blue =1;
        int [] colors = new int[vertices];
        Arrays.fill(colors, -1);
        for(int i=0;i<vertices;i++){
            if(colors[i]==-1){
                if(!isBipartiteDFS(adjList, colors, 0, i)) return false;
            }
        }
        System.out.println(adjList);
        return true;
    }

    private static boolean isBipartiteDFS(Map<Integer, List<Integer>> adjList, int[] colors, int currColor, int currNode) {
        colors[currNode] = currColor;
        List<Integer> visitingNodes = adjList.get(currNode);
        if(visitingNodes !=null){
            for(int v:visitingNodes){
                if(colors[v]==-1){
                    int colorsV = 1- currColor;
                    if(!isBipartiteDFS(adjList, colors, colorsV,v)) return false;
                }
            }
        }
        return true;
    }
}
