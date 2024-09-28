package com.prep;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int [][] graph = {{1},{0,3},{3},{1,2}};
        System.out.println(isBipartite(graph));
    }
    public static boolean isBipartite(int[][] graph) {
        int [] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for(int i=0;i<graph.length;i++){
            if(colors[i]==-1){
                if(!bipartiteBFS(graph, i, colors, 1))return false;
            }
        }
        return true;
    }
    private static boolean bipartiteBFS(int[][] adj, int node, int [] colors, int currColor){
        colors[node]= currColor;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int u = q.poll();
                for(int v:adj[u]){
                    if(colors[u]==colors[v]) return false;
                    else if(colors[v]==-1){
                        colors[v] = 1-colors[u];
                        q.add(v);
                    }
                }
        }
        return true;
    }
}
