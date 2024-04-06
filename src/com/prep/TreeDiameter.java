package com.prep;

import java.util.ArrayList;
import java.util.List;

//Leetcode #1245
public class TreeDiameter {
    private List<List<Integer>> graph;
    private int diameter;
    public int treeDiameter(int[][] edges) {
        boolean[] visited = new boolean[edges.length+1];
        for(int i=0;i<edges.length+1;i++){
            graph.add(new ArrayList<>());
            visited[i]= false;
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfsTreeDiameter(0, visited);
        return diameter;
    }

    private int dfsTreeDiameter(int curr, boolean[] visited) {
        int t1 =0;
        int t2 =0;
        visited[curr] = true;
        for(int neighbor:graph.get(curr)){
            int distance =0;
            if(!visited[neighbor]){
                distance =1 +this.dfsTreeDiameter(neighbor,visited);
            }
            if(distance >t1){
                t2 = t1;
                t1 = distance;
            }
            else if(distance>t2) t2 =distance;
        }
        this.diameter = Math.max(this.diameter, t1+t2);
        return t1;
    }
}
