package com.prep;

import java.util.*;

public class FindMinimumDiameterAfterMergingTwoTrees {
    public static void main(String[] args) {
        int [][] edges1 = {{0,1},{0,2},{0,3}}, edges2 = {{0,1}};
        int minDiameter = minimumDiameterAfterMerge(edges1, edges2);
        System.out.println(minDiameter);
    }

    private static int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int d1 = findDiameter(edges1);
        int d2 = findDiameter(edges2);
        int d1d2 = (((d1+1)/2)+((d2+1)/2))+1;
        int minDiameter = Math.max(d1d2,Math.max(d1,d2));
        return minDiameter;
    }

    private static int findDiameter(int[][] edges) {
        //calculate adj list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int n = edges.length+1;
        for(int [] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k->new ArrayList<>()).add(u);
        }
        int [] oneEnd = calculateFarthestNode(adj,n,0);
        int [] diaResult = calculateFarthestNode(adj,n,oneEnd[0]);
        return diaResult[1];
    }

    private static int[] calculateFarthestNode(Map<Integer, List<Integer>> adj, int n, int src) {
        boolean [] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src]=true;
        int level =0;
        int farthestNode = 0;
        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0){
                int current = q.poll();
                farthestNode =current;
                for(int ne: adj.getOrDefault(current, new ArrayList<>())){
                    if(!visited[ne]){
                        visited[ne] = true;
                        q.add(ne);
                    }
                }
            }
            if(!q.isEmpty())level++;
        }
        return new int[]{farthestNode, level};
    }
}
