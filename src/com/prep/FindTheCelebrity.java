package com.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheCelebrity {
    public static void main(String[] args) {
        int [][] graph = {{1,0,1},{1,1,0},{0,1,1}};
        int cel = findCel(graph);
        System.out.println(cel);
    }

    private static int findCel(int[][] graph) {
        int n = graph.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j]==1){
                    adj.computeIfAbsent(i, a->new ArrayList<>()).add(j);
                }
            }
        }
        System.out.println(adj);
        //find the celebreity
        for(int k:adj.keySet()){
            List<Integer> tempList = adj.get(k);
            if(tempList.size()==1){
                int ele = tempList.get(0);
                if(ele==k) return k;
            }
        }
        return -1;
    }
}
