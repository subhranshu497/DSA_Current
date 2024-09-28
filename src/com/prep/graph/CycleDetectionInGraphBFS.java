package com.prep.graph;

import java.util.*;

public class CycleDetectionInGraphBFS {
    public static void main(String[] args) {
        int [][] edges = {{0,2},{0,1}};
        int vertices = 3;
        boolean flag = checkCycleUsingBFS(edges, vertices);
        System.out.println(flag);
    }

    private static boolean checkCycleUsingBFS(int[][] edges, int vertices) {
        //create adj list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        System.out.println(adjList);
        //check for cycle using BFS
        boolean [] visited = new boolean[vertices];
        for(int i=0;i<vertices;i++){
            if(!visited[i] && checkCycleBFS(adjList, visited, i,-1)) return true;
        }
        return false;
    }

    private static boolean checkCycleBFS(Map<Integer, List<Integer>> adjList, boolean[] visited, int u, int parent) {
        Queue<Pair> q = new LinkedList<>();
        visited[u] = true;
        q.add(new Pair(u,parent));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int source = p.u;
            int currParent = p.parent;
            List<Integer> neighbors = adjList.get(source);
            for(int v:neighbors){
                if(!visited[v]){
                    visited[v]= true;
                    q.add(new Pair(v, source));
                }
                else if(v != currParent) return true;
            }
        }
        return false;
    }
}
class Pair{
    int u;
    int parent;
    public Pair(){}
    public Pair(int u, int parent){
        this.u=u;
        this.parent=parent;
    }

    @Override
    public String toString() {
        return "{" +
                 u +
                ", " + parent +
                '}';
    }
}
