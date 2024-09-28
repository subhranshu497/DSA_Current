package com.prep.graph.disjointSet.union;

import org.w3c.dom.xpath.XPathResult;

public class NumberOfOperationsToMakeNetworkConnected {
    public static void main(String[] args) {
        int [][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        int n = 6;
        int ops = makeConnected(connections, n);
        System.out.println(ops);
    }

    //i am doing it using Disjoint set union
    //so first code for find and union method
    //find method using path compression
    private static int find(int x, int [] parent){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x], parent);
    }
    //union by rank
    private static void union(int x, int y, int [] parent, int [] rank){
        int xParent = find(x, parent);
        int yParent = find(y, parent);
        if(xParent==yParent) return;
        if(rank[xParent]>rank[yParent]) parent[yParent]= xParent;
        else if(rank[xParent]<rank[yParent]) parent[xParent] =yParent;
        else{
            parent[xParent]=yParent;
            rank[yParent]++;
        }
    }
    private static int makeConnected(int[][] connections, int n) {
        int [] parent = new int[n];
        int [] rank = new int[n];
        //initialize parent and rank
        for(int i=0;i<n;i++){
            parent[i] =i;
            rank[i] =0;
        }
        if(connections.length < n-1) return -1;
        for(int[] edge: connections){
            int u= edge[0];
            int v= edge[1];
            int uParent = find(u, parent);
            int vParent = find(v, parent);
            if(uParent !=vParent){
                union(u,v,parent, rank);
                n--;
            }
        }
        return n-1;
    }
}
