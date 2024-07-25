package com.prep;

import java.util.*;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        int[][] edges = {{1,0},{1,2},{1,3}};
        int n = 4;
        List<Integer> mhts=findMinHeightTrees(n, edges);
        System.out.println(mhts);
    }
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) Q.offer(i);
        }

        while (n > 2) {
            int len = Q.size();
            n -= len;
            for (int i = 0; i < len; i++) {
                int node = Q.poll();
                for (int a : adj.get(node)) {
                    adj.get(a).remove((Integer) node);
                    if (adj.get(a).size() == 1) Q.offer(a);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!Q.isEmpty()) {
            result.add(Q.poll());
        }

        return result;
    }
}
