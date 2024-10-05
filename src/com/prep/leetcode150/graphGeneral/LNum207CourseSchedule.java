package com.prep.leetcode150.graphGeneral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LNum207CourseSchedule {
    public static void main(String[] args) {
        int [][] prerequisites = {{1,0}};
        int numCourses= 2;
        System.out.println(canFinish1(prerequisites, numCourses));
    }

    //it is a classic problem of graph traversal
    //returns true - if we can visit all the vertices, else false
    private static boolean canFinish1(int[][] prerequisites, int numCourses) {
        //Step -1  - create Adjecency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] prerequisite:prerequisites){
            int u = prerequisite[1];
            int v = prerequisite[0];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
        }
        boolean[] visitied = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visitied[i] && courseDFS(adjList, i, visitied, inRecursion))return false;
        }
        return true;
    }

    private static boolean courseDFS(Map<Integer, List<Integer>> adjList, int u, boolean[] visitied, boolean[] inRecursion) {
        visitied[u]=true;
        inRecursion[u] =true;
        if(adjList.get(u) !=null){
            for(int v: adjList.get(u)){
                if(!visitied[v] && courseDFS(adjList, v, visitied, inRecursion)){
                    return true;
                }
                else if(inRecursion[v]) return true;
            }
        }
        inRecursion[u] =false;
        return false;
    }
}
