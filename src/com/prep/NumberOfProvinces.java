package com.prep;

import java.util.*;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }

    private static int findCircleNum(int[][] isConnected) {
        int noOfCities=0;
        boolean [] visited = new boolean[isConnected.length];
        //create adjList
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=0;i< isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && i !=j){
                    adjList.putIfAbsent(i, new ArrayList<>());
                    adjList.putIfAbsent(j, new ArrayList<>());
                    adjList.get(i).add(j);
                   // adjList.get(j).add(i);
                }
            }
        }
        System.out.println(adjList);
        //call dfs
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                noOfCities++;
                numberOfProvinceBFS(adjList, visited,i);
            }
        }
        return noOfCities;
    }

    private static void numberOfProvinceDFS(Map<Integer, List<Integer>> adjList, boolean[] visited, int u) {
        visited[u] = true;
        List<Integer> neighbors = adjList.get(u);
        if(neighbors==null)return;
        for(int v: neighbors){
            if(!visited[v])numberOfProvinceDFS(adjList, visited,v);
        }
    }
    private static void numberOfProvinceBFS(Map<Integer, List<Integer>> adjList, boolean[] visited, int src) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src]=true;
        while(!q.isEmpty()){
            int u = q.poll();
            List<Integer> neightbors = adjList.get(u);
            if(neightbors ==null)continue;
            for(int v:neightbors){
                if(!visited[v]){
                    numberOfProvinceBFS(adjList, visited, v);
                }
            }
        }
    }
}
