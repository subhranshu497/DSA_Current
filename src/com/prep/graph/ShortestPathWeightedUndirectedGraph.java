package com.prep.graph;

import java.util.*;

public class ShortestPathWeightedUndirectedGraph {
    public static void main(String[] args) {
        int n = 5, m= 6;
        int [][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        List<Integer> shortestPath = shortestPath(n, m, edges);
        System.out.println(shortestPath);
    }

    private static List<Integer> shortestPath(int n, int m, int[][] edges) {
        int source =1;
        int destination =5;
        int[] parent = new int[n+1];
        // at start node is its parent self
        for(int i=1;i<=n;i++)parent[i]=i;
        //source 1, destination 5
        // create adjecency Matrix
        Map<Integer, List<Pair>> adjList = new HashMap<>();
        for(int [] edge:edges){
            int u= edge[0];
            int v= edge[1];
            int w =edge[2];
            adjList.putIfAbsent(u,new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(new Pair(v,w));
            adjList.get(v).add(new Pair(u,w));
        }
        System.out.println(adjList);
        int [] result = new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        //process Dijkstra
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(p->p.weight));
        result[source]=0;
        pq.add(new Pair(1,0));
        //everytime start processing put the parent node in the array
        parent[source]=source;
        while (!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.v;
            int wt = p.weight;
            if(adjList.get(u)!=null){
                for(Pair neighbor:adjList.get(u)){
                    int v = neighbor.v;
                    int w = neighbor.weight;
                    if(w+wt <result[v]){
                        result[v] = w+wt;
                        pq.add(new Pair(v, w+wt));

                        parent[v]=u;
                    }
                }
            }
        }
        if(result[destination]==Integer.MAX_VALUE) return List.of(-1);
        int node =destination;
        List<Integer> path = new ArrayList<>();
        while(parent[node] !=node){
           path.add(node);
           node = parent[node];
        }
        path.add(source);
        //reverse the items in the list
        Collections.reverse(path);
        return path;
    }
    static class Pair{
        int v;
        int weight;
        Pair(int v, int weight){
            this.v =v;
            this.weight = weight;
        }
        @Override
        public String toString() {
            return "{" +
                    v +
                    ", " + weight +
                    '}';
        }
    }
}
