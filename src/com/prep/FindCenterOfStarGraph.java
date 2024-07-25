package com.prep;

import java.util.HashMap;
import java.util.Map;

public class FindCenterOfStarGraph {
    public static void main(String[] args) {
        int [][] edges = {{1,2},{2,3},{4,2}};
        int center = findCenter(edges);
        System.out.println(center);
    }

    private static int findCenter(int[][] edges) {
        int center = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< edges.length;i++){
            map.put(edges[i][0],map.getOrDefault(edges[i][0],0)+1);
            map.put(edges[i][1],map.getOrDefault(edges[i][1],0)+1);
        }
        int temp=0;
        for (Map.Entry<Integer,Integer> e:map.entrySet()){
            int key = e.getKey();
            int val = e.getValue();
            if(temp<val){
                temp =val;
                center=key;
            }
        }
        return center;
    }
}
