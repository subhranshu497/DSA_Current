package com.prep;

import java.util.*;

public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int source = 0;
        int destination=5;
        int n = 5;
        System.out.println(validPath(edges, source, destination,n));
    }

    private static boolean validPath(int[][] edges, int source, int destination, int n) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            adjList.computeIfAbsent(a, val->new ArrayList<>()).add(b);
            adjList.computeIfAbsent(b, val->new ArrayList<>()).add(a);
        }
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr==destination) return true;
            for(int nextNode: adjList.get(curr)){
                if(!seen[nextNode]){
                    seen[nextNode]=true;
                    q.offer(nextNode);
                }
            }
        }
        return false;
    }
}
