package com.prep.graph;

import java.util.*;

public class DijkstraAlgoByCreatingAdjListMap {
    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        int source =0;
        int V =9;
        dijkstraAlgoImplTwo(graph,source, V);
    }

    private static void dijkstraAlgoImplTwo(int[][] graph, int source, int V) {
        //create adj list
        Map<Integer, List<Pair>> adjList = new HashMap<>();
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(graph[i][j] !=0){
                    adjList.putIfAbsent(i,new ArrayList<>());
                    adjList.get(i).add(new Pair(j,graph[i][j]));
                }
            }
        }
        //creating a min heap based on the weight
        //pair with less weight value will be on the top
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(p->p.weight));
        int [] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[source] = 0;
        pq.add(new Pair(source, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.node;
            int wt = p.weight;
            //iterate the list
            if(adjList.get(u) !=null){
                for(Pair pair:adjList.get(u)){
                    int v = pair.node;
                    int w = pair.weight;
                    if(wt+w < result[v]){
                        result[v] = wt+w;
                        pq.add(new Pair(v, wt+w));
                    }
                }
            }
        }
        //print result
        for(int i=0;i<V;i++){
            System.out.println("Distance of "+i+" node from "+source+" node is "+result[i]);
        }
    }
    static class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "node=" + node +
                    ", weight=" + weight +
                    '}';
        }
    }
}
