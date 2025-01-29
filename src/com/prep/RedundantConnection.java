package com.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedundantConnection {
    public static void main(String[] args) {
        int [][] edges  = {{1,2},{1,3},{2,3}};
        int [] result = findRedundantConnection(edges);
        System.out.println(result[0]+", "+result[1]);
    }

    private static int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        //create adjList
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            if(adjList.containsKey(u) && adjList.containsKey(v)){
                boolean [] vistited = new boolean[edges.length+1];
                if(findRedundantConnectionDFS(adjList, vistited,u,v))
                    return edge;
            }
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(u);
        }
        return new int[]{0,0};
    }

    private static boolean findRedundantConnectionDFS(Map<Integer, List<Integer>> adjList, boolean[] vistited, int u, int v) {
        vistited[u] = true;
        if(u==v) return true;
        for(int ne:adjList.get(u)){
            if(vistited[ne]) continue;
            if(findRedundantConnectionDFS(adjList, vistited,ne,v))
                return true;
        }
        return false;
    }
}
