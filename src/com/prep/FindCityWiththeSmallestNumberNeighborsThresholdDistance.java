package com.prep;

import java.util.Arrays;

public class FindCityWiththeSmallestNumberNeighborsThresholdDistance {
    public static void main(String[] args) {
        int n =4;
        int [][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;
        int city= findTheCity(edges, distanceThreshold,n);
    }

    //it can be sloved using Floyd-warshall algo
    private static int findTheCity(int[][] edges, int distanceThreshold, int n) {
        //initialize the matrix;
        int[][]fwMat= new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(fwMat[i],10001);
            fwMat[i][i] = 0;
        }
        //construct the matrix
        for(int [] edge:edges){
            int src = edge[0];
            int dest = edge[1];
            fwMat[src][dest]=edge[2];
            fwMat[dest][src]=edge[2];
        }
        //now calculate the matrixes for each node
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    fwMat[i][j] = Math.min(fwMat[i][j], (fwMat[i][k]+fwMat[k][j]));
                }
            }
        }
        int minReachableCities =n;
        int city =0;
        for(int i=0;i<n;i++){
            int reachableCitiesCount = 0;
            for(int j=0;j<n;j++){
                if(fwMat[i][j]<=distanceThreshold) reachableCitiesCount++;
            }
            if(reachableCitiesCount <=minReachableCities){
                minReachableCities = reachableCitiesCount;
                city =i;
            }
        }
        return city;
    }
}
