package com.prep;

import java.util.*;

public class DivideNodesIntoTheMaximumNumberOfGroups {
    public static void main(String[] args) {
        int n = 92;
        int [][] edges = {{67,29},{13,29},{77,29},{36,29},{82,29},{54,29},{57,29},{53,29},{68,29},{26,29},{21,29},{46,29},{41,29},{45,29},{56,29},{88,29},{2,29},{7,29},{5,29},{16,29},{37,29},{50,29},{79,29},{91,29},{48,29},{87,29},{25,29},{80,29},{71,29},{9,29},{78,29},{33,29},{4,29},{44,29},{72,29},{65,29},{61,29}};
        int sets = magnificentSets(n, edges);
        System.out.println(sets);
    }

    private static int magnificentSets(int n, int[][] edges) {
        //create adjacency List
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] edge:edges){
            int u = edge[0]-1;
            int v = edge[1]-1;
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(u);
        }
        //check bipartite
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for(int i=0;i<n;i++){
            if(colors[i]==-1){
                if(!isBipartite1(adjList,i, colors,1))
                    return -1;
            }
        }
        //now do BFS
        int [] levels = new int[n];
        for(int i=0;i<n;i++){
            levels[i] = bfsToFindMagSets(adjList, i,n);
        }
        int maxGroupForEach = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                maxGroupForEach +=getMaxFromEachComponent(adjList, i, visited, levels);
            }
        }
        return maxGroupForEach;
    }

    private static int getMaxFromEachComponent(Map<Integer, List<Integer>> adjList, int i, boolean[] visited, int[] levels) {
        int maxGroup = levels[i];
        visited[i] = true;
        for(int ne:adjList.getOrDefault(i, Collections.emptyList())){
            if(!visited[ne])
                maxGroup = Math.max(maxGroup, getMaxFromEachComponent(adjList,ne,visited,levels));
        }
        return maxGroup;
    }

    private static int bfsToFindMagSets(Map<Integer, List<Integer>> adjList, int curr, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        visited[curr] = true;
        int level =1;
        while(!q.isEmpty()){
            int size = q.size();
            while (size-- >0){
                int currNode = q.poll();
                for(int ne:adjList.getOrDefault(currNode, Collections.emptyList())){
                    if(visited[ne])
                        continue;
                    q.add(ne);
                    visited[ne]= true;
                }
            }
            level++;
        }
        return level-1;
    }

    private static boolean isBipartite1(Map<Integer, List<Integer>> adjList, int i, int[] colors, int currColor) {
        colors[i]= currColor;
        for(int ne:adjList.getOrDefault(i, Collections.emptyList())){
            if(colors[ne]==colors[i])
                return false;
            if(colors[ne]==-1){
                if(!isBipartite1(adjList, ne, colors, 1-currColor))
                    return false;
            }
        }
        return true;
    }
}
