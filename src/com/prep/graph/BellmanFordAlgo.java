package com.prep.graph;

import java.util.Arrays;

//it works only on directed weighted graph where weight can be negative
// it will find the shortest distance from source to all node just like Dijkstra algo
// but it works on the edges with negative edge unlike Dijkstra
public class BellmanFordAlgo {
    public static void main(String[] args) {
        int [][] edges = {{0,1,5},{1,0,3},{1,2,-1},{2,0,1}};
        int source =2;
        int V = 3;
        int [] result = bellmanFord(edges, source, V);
        for(int i=0;i< result.length;i++){
            System.out.print(result[i]+", ");
        }
    }
//in Bellman Ford algo processing order of edges is important
    // we should process V-1 times to get the shortest distance
    //if we will process V times , and find any changes in result array , then there axists a negative cycle
    private static int[] bellmanFord(int[][] edges, int source, int V) {
        int [] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[source]=0;
        for(int count=1;count<=V-1;count++){
            for(int [] edge:edges){
                int u=edge[0];
                int v = edge[1];
                int w = edge[2];
                if(result[u] !=Integer.MAX_VALUE && result[u]+w < result[v]){
                    result[v] = result[u]+w;
                }
            }
        }
        return result;
    }
}
