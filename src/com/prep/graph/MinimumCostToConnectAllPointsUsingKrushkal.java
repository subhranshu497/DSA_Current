package com.prep.graph;

import java.util.*;

public class MinimumCostToConnectAllPointsUsingKrushkal {
    public static void main(String[] args) {
        int [][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        int minCost = minCostCalculationUsingKruskal(points);
        System.out.println(minCost);
    }

    private static int minCostCalculationUsingKruskal(int[][] points) {
         int [] parent = new int[points.length];
        int[] rank = new int[points.length];
        for(int i=0;i< points.length;i++){
            parent[i]=i;
        }
        //step -1 - create adj list
        List<int[]> adjList = new ArrayList<>();
        for(int i=0;i<points.length;i++){
            int x1 =points[i][0];
            int y1 =points[i][1];
            for(int j=i+1;j< points.length;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int wt = Math.abs(x1-x2)+Math.abs(y1-y2);
                adjList.add(new int[]{i,j,wt});
            }
        }
        //print adj list
        for(int [] point:adjList){
            System.out.println(point);
        }
        //step -2 - sort the adjacency list
        Collections.sort(adjList, (a,b)->a[2]-b[2]);
        //step - 3 - Apply DSU - Disjoint set union
        int mst =0;
        for(int [] point:adjList){
            int x = point[0];
            int y = point[1];
            int w = point[2];
            int xP = find(x,parent);
            int yP = find(y, parent);
            if(xP != yP){
                union(x, y, parent, rank);
                mst +=w;
            }
        }
        return mst;
    }
    private static int find(int x, int [] parent){
        if(x == parent[x]) return x;
        return parent[x]=find(parent[x], parent);
    }
    private static void union(int x, int y, int [] parent, int [] rank){
        int parentX = find(x, parent);
        int parentY = find(y, parent);
        if(parentY==parentX) return;
        if(rank[parentX] > rank[parentY]) parent[parentY]=parentX;
        else if(rank[parentX] < rank[parentY]) parent[parentX]=parentY;
        else{
            parent[parentY]=parentX;
            rank[parentX]++;
        }
    }
}
