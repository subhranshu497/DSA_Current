package com.prep.graph;

import java.util.*;

public class CycleDetectionInDirectedGraphUsingBFS {
    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0,3));
        edges.add(Arrays.asList(3,1));
        edges.add(Arrays.asList(1,4));
        edges.add(Arrays.asList(5,4));
        edges.add(Arrays.asList(5,1));
        edges.add(Arrays.asList(2,1));
        edges.add(Arrays.asList(2,3));
        edges.add(Arrays.asList(0,2));
        int vertics = 6;
        boolean flag = cycleDetectionUsingBFS(edges, vertics);
        System.out.println(flag);
    }

    private static boolean cycleDetectionUsingBFS(List<List<Integer>> edges, int vertics) {
        //create adj list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(List<Integer> edge:edges){
            int u= edge.get(0);
            int v = edge.get(1);
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        System.out.println(adjList);
        int [] indegree = new int[vertics];
        int count =0;
        for(int u=0;u<vertics;u++){
            for(int v: adjList.get(u)){
                indegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<vertics;i++){
            if(indegree[i]==0){
                q.add(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v:adjList.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    count++;
                    q.add(v);
                }
            }
        }
       return count==vertics?false:true;
    }
}
