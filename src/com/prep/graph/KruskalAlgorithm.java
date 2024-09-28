package com.prep.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Kruskal's Algo is to find Minimum Spanning tree for a graph
 * how to find minimum spanningtree using Kruskal
 * step-1 : - Create an adjacency List --> (u,v,W)
 * step -2: - Sort the adjacency list w.r.t weigth
 * Stp -3: - Apply Disjoint Set Union
 *  3.1 - Find the parent(u) and parent(v)
 *  if both are equal, then there is already a connection , so add the edge weight to the mst
 *  Else do union of u and V, add the edge weight
 *  once all the vertices have single parent, then return the mst
 */
public class KruskalAlgorithm {
    private static int V =3;
    private static int E = 3;
    private static int parent [] = new int[V];
    private static int rank [] = new int[V];
    private static void initializeParent(){
        for(int i=0;i<V;i++){
            parent[i] = i;
        }
    }
    public static void main(String[] args) {
        int [][] edges = {{0,1,5},{1,2,3},{0,2,1}};
        int mst = kruskalsAlgoMST(V,E, edges);
        System.out.println("Minimum spanning Tree : - "+mst);
    }

    private static int kruskalsAlgoMST(int V, int E, int[][] edges) {
        //step -1 :- create adjacency List
        //here dont need to create adj list, already we have 2d array
        //Step-2: sort the edges based on weight (2nd index)
        Arrays.sort(edges, (a,b)->Integer.compare(a[2],b[2]));
        //to print the sorted array
        for(int [] edge:edges){
            System.out.println(Arrays.toString(edge));
        }
        initializeParent();
        //step-3 :- DSU - disjoint set union
        int mst =0;
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            int uParent = find(u);
            int vParent = find(v);
            if(uParent !=vParent){
                union(u, v);
                mst +=w;
            }
        }
        return mst;
    }
    //DSU - code for find
    private static int find(int x){
        if(parent[x]==x) return x;

        return parent[x] = find(parent[x]);
    }
    private static void union(int x, int y){
        int xP = find(x);
        int yP = find(y);
        if(xP == yP) return;
        if(rank[xP] >rank[yP]){
            parent[yP] = xP;
        }
        else if(rank[yP]>rank[xP]){
            parent[xP] = yP;
        }
        else{
            parent[xP]=yP;
            rank[yP]++;
        }
    }
}
