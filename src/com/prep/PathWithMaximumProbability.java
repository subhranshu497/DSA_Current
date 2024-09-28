package com.prep;

import java.util.*;

public class PathWithMaximumProbability {
    public static void main(String[] args) {
        int [][] edges = {{0,1},{1,2},{0,2}};
        double [] succProb = {0.5, 0.5,0.2};
        int n =3;
        int start = 0;
        int end = 2;
        double result = maxProbability(edges, succProb,n, start, end);
        System.out.println(result);
    }

    private static double maxProbability(int[][] edges, double[] succProb, int n, int start, int end) {
        //create an adjacency list
        Map<Integer, List<Pair>> adjList = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(new Pair(v,w));
            adjList.get(v).add(new Pair(u,w));
        }
        System.out.println(adjList);
        double [] visit = new double[n];
        Queue<Integer> q = new LinkedList<>();
        visit[start] =1;
        q.add(start);
        while(!q.isEmpty()){
            int currNode = q.poll();
            List<Pair> neighbors = adjList.get(currNode);
            if(neighbors==null)continue;
            for(Pair neighbor : neighbors){
                int nextDest = neighbor.v;
                double nextWeight = neighbor.w;
                double maxProb = visit[currNode]*nextWeight;
                if(maxProb > visit[nextDest]){
                    visit[nextDest]= maxProb;
                    q.add(nextDest);
                }
            }
        }
        return visit[end];
    }
}
class Pair{
    int v;
    double w;
    public Pair(){}
    public Pair(int v , double w){
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "v=" + v +
                ", w=" + w +
                '}';
    }
}
