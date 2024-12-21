package com.prep;

import java.util.*;

public class MaximumNumberOfKDivisibleComponents {
    public static void main(String[] args) {
        int n = 5, k = 6;
        int [][] edges = {{0,2},{1,2},{1,3},{2,4}};
        int [] values = {1,8,1,4,4};
        int count = maxKDivisibleComponents(n,k,edges,values);
        System.out.println(count);
    }

    private static int maxKDivisibleComponents(int n, int k, int[][] edges, int[] values) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int count[] ={0};
        maxKDivisibleComponentsDfs(n,k,adj,values,count,0,-1);
        return count[0];
    }

    private static int maxKDivisibleComponentsDfs(int n, int k, Map<Integer, List<Integer>> adj, int[] values,int[] count, int curr, int parent) {
        long sum = values[curr];
        if(adj.get(curr) != null) {
            for (int ne : adj.get(curr)) {
                if (ne != parent) {
                    sum += maxKDivisibleComponentsDfs(n, k, adj, values, count, ne, curr);
                }
            }
        }
        sum %=k;
        if(sum ==0)count[0]++;

        return (int) sum;
    }
}
