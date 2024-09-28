package com.prep.graph;

import com.prep.MinimumNumberOfMovesToSeatEveryone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * To find out number of strongly connected component Kosaraju algorithm helps
 * Step 1 - do dfs and put all nodes in a stack
 * Step 2 - Reverse the graph (by reversing its edges)
 * step 3 - iterate the stack by visting the edges of reversed graph
 * the number of times dfs is being called on reversed graph, thats the number of strongly connected components in the graph
 */
public class StronglyConnectedComponents {
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        // Initialize the adjacency list for each vertex
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add directed edges (graph is represented as adjacency list)
        addEdge(adj, 1, 0);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 3, 4);

        // Print the adjacency list to see the graph structure
        System.out.println("Graph adjacency list:");
        for (int i = 0; i < adj.size(); i++) {
            System.out.println(i + " -> " + adj.get(i));
        }

        //Kosaraju's algorithm to find out strongly connected components
        int scc = stronglyConCom(V, adj);
        System.out.println("Strongly Connected Component-----> "+scc);
    }

    private static int stronglyConCom(int V, List<List<Integer>> adj) {
        //Step -1: - dfs to fill the stack , in topo sort order
        boolean [] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfsToFillStack(adj, visited, i,st);
            }
        }
        //step -2 - reverse the graph
        List<List<Integer>> reverseAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            reverseAdj.add(new ArrayList<>());
        }
        for(int u=0;u<V;u++){
            if(adj.get(u).size() !=0){
                for(int v:adj.get(u)){
                    reverseAdj.get(v).add(u);
                }
            }
        }
        //step -3 - process the stack
        int scc =0;
        Arrays.fill(visited, false);
        while(!st.isEmpty()){
            int node = st.pop();
            if(!visited[node]){
                dfsToEmptyStack(reverseAdj, visited, node);
                scc++;
            }
        }
        return scc;
    }

    private static void dfsToEmptyStack(List<List<Integer>> reverseAdj, boolean[] visited, int u) {
        visited[u] = true;
        for(int v:reverseAdj.get(u)){
            if(!visited[v]){
                dfsToEmptyStack(reverseAdj, visited,v);
            }
        }
    }

    private static void dfsToFillStack(List<List<Integer>> adj, boolean[] visited, int u, Stack<Integer> st) {
        visited[u]=true;
        for(int v:adj.get(u)){
            if(!visited[v]){
                dfsToFillStack(adj, visited, v, st);
            }
        }
        st.push(u);
    }

    public static void addEdge(List<List<Integer>> adj, int from, int to) {
    adj.get(from).add(to);
    }

}
