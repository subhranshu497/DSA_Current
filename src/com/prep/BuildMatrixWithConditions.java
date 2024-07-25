package com.prep;

import java.util.*;

public class BuildMatrixWithConditions {
    public static void main(String[] args) {
        int [][] rowConditions = {{1,2,},{3,2}};
        int [][] colConditions = {{2,1},{3,2}};
        int k =3;
        int [][] matrix = buildMatrix(rowConditions,colConditions,k);
    }

    private static int[][] buildMatrix(int[][] rowConditions, int[][] colConditions, int k) {
        //use topological sort to find out ordering of col and row
        List<Integer> topoRow = topologocalSort(rowConditions,k);
        List<Integer> topoCol = topologocalSort(colConditions,k);
        int [][] matrix = new int[k][k];

        //if there is a cycle - ans is not possible
        if(topoRow.isEmpty() || topoCol.isEmpty()) return matrix;

        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                if(topoRow.get(i)==topoCol.get(j))matrix[i][j] = topoRow.get(i);
            }
        }
        return matrix;
    }

    private static List<Integer> topologocalSort(int[][] edges, int k) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(!adj.containsKey(u)){
                List<Integer> l = new ArrayList<>();
                l.add(v);
                adj.put(u,l);
            }
            else{
                List<Integer> l = adj.get(u);
                l.add(v);
                adj.put(u,l);
            }
        }
        //vistied[i]=0 - not visited
        //visited[i]=1 - dfs is going on
        //visited[i]=2 - viited
        int [] visited = new int[k+1];
        Arrays.fill(visited,0);
        Stack<Integer> st = new Stack<>();
        boolean cycle = false;
        List<Integer> order = new ArrayList<>();
        for(int i=1;i<=k;i++){
            if(visited[i]==0){
                dfstopomatrix(i, visited, adj, st, cycle);
                if(cycle){
                    return new ArrayList<>();
                }
            }
        }
        while(!st.empty()){
            order.add(st.pop());
        }
        return order;
    }

    private static void dfstopomatrix(int i, int[] visited, Map<Integer, List<Integer>> adj, Stack<Integer> st, boolean cycle) {
        visited[i]=1;
        for(int l:adj.get(i)){
            if(visited[l]==0){
                dfstopomatrix(l,visited,adj,st,cycle);
            }
            else if(visited[l]==1){
                cycle = true;
                return;
            }
            visited[i]=2;
            st.push(i);
        }
    }
}
