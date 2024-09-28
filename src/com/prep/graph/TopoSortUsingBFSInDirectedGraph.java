package com.prep.graph;

import com.prep.MinimumNumberOfMovesToSeatEveryone;

import java.util.*;

/*
this also known as Kahn's Algorithm
 */
public class TopoSortUsingBFSInDirectedGraph {
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
        List<Integer> result = topoSortUsingBFS(edges, vertics);
        System.out.println(result);
    }

    private static List<Integer> topoSortUsingBFS(List<List<Integer>> edges, int vertics) {
        //step 1 - prepare adjacency List
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(List<Integer> edge:edges){
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
        }
        System.out.println(adjList);
        System.out.println();
        //step 2 - prepare indegree array by traversing the adj list
        int [] indegree = new int[vertics];
        for(int i=0;i<vertics;i++){
            for(int v:adjList.get(i)){
                indegree[v] +=1;
            }
        }
        //to print indegree
        for(int i=0;i<vertics;i++){
            System.out.print(indegree[i]+", ");
        }
        //step-3 - traverse using BFS
        //add the verties into Queue whose indegree is 0 and while iteratin he nodes, decrement the indegree value by 1 for the visited nodes
        //once indegree == 0 add those into the queue and start visiting its children
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<vertics;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        //simple BFS
        while(!q.isEmpty()){
            int u = q.poll();
            result.add(u);
            for(int v:adjList.get(u)){
                indegree[v] -=1;
                if(indegree[v] ==0){
                    q.add(v);
                }
            }
        }
        System.out.println(result);
        return result;
    }

}
