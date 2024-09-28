package com.prep.graph.disjointSet.union;

public class DisjointSet {

    //this two are the most primitive way to solve
    private int find(int x, int [] parent){
        if (x == parent[x]) return x;
        return find(parent[x], parent);
    }
    private void union(int x, int y, int [] parent){
        int xParent = find(x, parent);
        int yParent = find(y, parent);
        if(xParent != yParent){
            parent[xParent] = yParent;
        }
    }
}
