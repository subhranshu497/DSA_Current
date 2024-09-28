package com.prep.graphConcept;

/**
 * This algorithm defines all pair of shortest path from each node to its all nodes
 */
public class FloydWarshallAlgo {
    public static void main(String[] args) {
        int graph[][] = {
                {0, 3, Integer.MAX_VALUE, 5},
                {2, 0, Integer.MAX_VALUE, 4},
                {Integer.MAX_VALUE, 1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 2, 0}
        };
        int n=4;
        int [][]dist = allPairOfShortestPath(graph,n);
        //print solution
            System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] == Integer.MAX_VALUE) {
                        System.out.print("INF ");
                    } else {
                        System.out.print(dist[i][j] + "   ");
                    }
                }
                System.out.println();
        }
    }

    private static int[][] allPairOfShortestPath(int[][] graph, int n) {
        int [][] dist = new int[n][n];
        //initialize solution matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = graph[i][j];
            }
        }

        for(int k=0;k<=n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]+dist[k][j]<dist[i][j]){
                        dist[i][j] = dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        return dist;
    }
}
