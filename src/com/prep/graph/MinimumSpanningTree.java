package com.prep.graph;

import java.util.*;

public class MinimumSpanningTree {
    public static void main(String[] args) {
        int V=3;
        int E =3;
        int[][] edges = {
                {0, 1, 5},
                {1, 2, 3},
                {0, 2, 1}
        };
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w =edge[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }

        int mst = spanningTree(V,E, adj);
        System.out.println(mst);
    }

    private static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(p->p.wt));
        boolean [] mst = new boolean[V];
        int sum =0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int wt = p.wt;
            if(mst[node])continue;
            mst[node] = true;
            sum +=wt;
            for(int [] temp:adj.get(node)){
                int v = temp[0];
                int w = temp[1];
                if(!mst[v])pq.add(new Pair(v, w));
            }
        }
        return sum;
    }
    static class Pair{
        int node;
        int wt;
        Pair(int node, int wt){
            this.node= node;
            this.wt = wt;
        }
    }
}
