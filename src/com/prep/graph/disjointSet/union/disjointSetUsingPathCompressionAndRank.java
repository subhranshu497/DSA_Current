package com.prep.graph.disjointSet.union;

public class disjointSetUsingPathCompressionAndRank {
    public int find(int x ,int [] parent){
        if(x == parent[x]) return x;
        //path compression , because we are trying to assign one parent for all the nodes
        return parent[x]=find(parent[x], parent);
    }
    //unionBy rank matrix
    //the node who has higher rank will be the parent
    public void union(int x, int y, int [] parent, int [] rank){
        int xParent = find(x, parent);
        int yParent = find(y, parent);
        if(xParent == yParent) return;
        if(rank[xParent] > rank[yParent]){
            parent[yParent] = xParent;
        }
        else if(rank[xParent] < rank[yParent]){
            parent[xParent] = yParent;
        }
        else{
            parent[xParent] =yParent;
            rank[yParent]++;
        }
    }
}
