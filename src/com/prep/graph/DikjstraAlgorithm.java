package com.prep.graph;

import java.util.*;

public class DikjstraAlgorithm {
    public static void main(String[] args) {
        List<int[]>[] edges = new ArrayList[3];

        for (int i = 0; i < 3; i++) {
            edges[i] = new ArrayList<>();
        }

        edges[0].add(new int[]{1, 1}); // edge 0 -> 1 with weight 1
        edges[0].add(new int[]{2, 6}); // edge 0 -> 2 with weight 6
        edges[1].add(new int[]{2, 3}); // edge 1 -> 2 with weight 3
        int V = 3;
        int source =0;
        List<Integer> result = dijkstraAlgoImpl(edges, V, source);
        System.out.println(result);
    }

    private static List<Integer> dijkstraAlgoImpl(List<int[]>[] edges, int V, int source) {
        PriorityQueue<Pair>pq = new PriorityQueue<>(Comparator.comparing(p->p.wt));
        int [] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[source]=0;
        pq.add(new Pair(source,0));
        while (!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.node;
            int wt = p.wt;
            //traverse each node
            for(int[] edge:edges[u]){
                int v = edge[0];
                int w = edge[1];
                if(wt+w < result[v]){
                    result[v]=wt+w;
                    pq.add(new Pair(v, wt+w));
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int num:result)list.add(num);
        return list;
    }
    static class Pair{
        int node;
        int wt;
         Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
}

