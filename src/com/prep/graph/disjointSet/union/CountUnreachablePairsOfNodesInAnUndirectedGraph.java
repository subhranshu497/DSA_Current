package com.prep.graph.disjointSet.union;

import java.util.HashMap;
import java.util.Map;

public class CountUnreachablePairsOfNodesInAnUndirectedGraph {
    public static void main(String[] args) {
        int n =7;
        int [][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}};
        int count = countPairsDSU(n, edges);
        System.out.println(count);
    }

    private static int countPairsDSU(int n, int[][] edges) {
        int [] parent = new int[n];
        int [] rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        for(int [] edge:edges){
            union(edge[0], edge[1], parent, rank);
        }
        //create a map to store component and its size
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int compnents = find(i, parent);
            map.put(compnents,map.getOrDefault(compnents,0)+1);
        }
        System.out.println(map);
        int count =0;
        int remaining =n;
        //iterate map and find result
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            int key = e.getKey();
            int size = e.getValue();
            count +=size *(remaining-size);
            remaining -=size;
        }
        return count;
    }
    private static int find(int x, int [] parent){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }
    private static void union(int x , int y, int [] parent, int [] rank){
        int xParent = find(x, parent);
        int yParent = find(y, parent);
        if(xParent == yParent) return;
        if(parent[xParent]>parent[yParent])parent[yParent] = xParent;
        else if(parent[xParent]<parent[yParent])parent[xParent] = yParent;
        else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
}
