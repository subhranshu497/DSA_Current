package com.prep;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(minReorder(n , connections));
    }

    private static int minReorder(int n, int[][] connections) {
        List<List<Integer>> el = new ArrayList<>();
        for(int i=0;i<n;i++){
            el.add(new ArrayList<>());
        }
        for(int[] connection:connections){
            el.get(connection[0]).add(connection[1]);
            el.get(connection[1]).add(-connection[0]);
        }
        return citiesDfs(el, new boolean[n],0);
    }

    private static int citiesDfs(List<List<Integer>> el, boolean[] visited, int root) {
        int count =0;
        visited[root]= true;
        for(int to:el.get(root)){
            if(!visited[Math.abs(to)]){
                count +=citiesDfs(el,visited, Math.abs(to))+((to>0)?1:0);
            }
        }
        return count;
    }
}
