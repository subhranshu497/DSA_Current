package com.prep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinmumCostToConnectAllPoints {
    public static void main(String[] args) {
        int [][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        int minimumCost = minCostConnectPoints(points);
        System.out.println(minimumCost);
    }

    private static int minCostConnectPoints(int[][] points) {
        int V = points.length;
        //create adj list
        List<List<int []>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){

            for(int j=i+1;j<V;j++){
                int xPrev = points[i][0];
                int yPrev = points[i][1];
                int x = points[j][0];
                int y = points[j][1];
                int wt = Math.abs(xPrev-x)+Math.abs(yPrev-y);
                adj.get(i).add(new int[]{j,wt});
                adj.get(j).add(new int[]{i,wt});
            }
        }
        //apply MST
        int sum =0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(p->p.wt));
        pq.add(new Pair(0,0));
        boolean [] mst = new boolean[V];
        while (!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int wt = p.wt;
            if(mst[node])continue;
            mst[node]=true;
            sum +=wt;
            for(int [] edge:adj.get(node)){
                int v= edge[0];
                int w = edge[1];
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
