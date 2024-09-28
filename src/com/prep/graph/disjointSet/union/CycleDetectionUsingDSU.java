package com.prep.graph.disjointSet.union;

public class CycleDetectionUsingDSU {
    public static void main(String[] args) {
        int[][] adj = {{0, 1}, {1, 2}};
        int V = 3;
        boolean flag = cycleDetectionDSU(adj, V);
        System.out.println(flag);
    }

    private static boolean cycleDetectionDSU(int[][] adj, int V) {
        int[] parent = new int[V];
        int[] rank = new int[V];
        //initialize parent and rank matrix
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        //process the adjacency list
        for (int[] edge : adj) {
            int u = edge[0];
            int v = edge[1];
            if (u < v) {
                int parentU = find(u, parent);
                int parentV = find(v, parent);
                if (parentU == parentV) return true;
                union(u, v, parent, rank);
            }
        }
        return false;
    }

    private static int find(int x, int[] parent) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }

    private static void union(int x, int y, int[] parent, int[] rank) {
        int xp = find(x, parent);
        int yp = find(y, parent);
        if (xp == yp) return;
        if (rank[xp] > rank[yp]) parent[yp] = xp;
        else if (rank[xp] < rank[yp]) parent[xp] = yp;
        else {
            parent[xp] = yp;
            rank[yp]++;
        }
    }
}
