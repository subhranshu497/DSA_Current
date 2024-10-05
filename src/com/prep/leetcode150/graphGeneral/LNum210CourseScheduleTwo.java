package com.prep.leetcode150.graphGeneral;

import java.util.*;

public class LNum210CourseScheduleTwo {
    static boolean hasCycle = false;
    public static void main(String[] args) {
        int numCourses = 4;
        int [][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int [] ans = findOrderOne(numCourses, prerequisites);
        for(int num:ans) System.out.print(num+"num ");
    }

    private static int[] findOrderOne(int numCourses, int[][] prerequisites) {
        //first create the adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] prerequisite:prerequisites){
            int u = prerequisite[1];
            int v = prerequisite[0];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
        }
        boolean [] visited = new boolean[numCourses];
        boolean [] inRecursion = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(courseScheduleTwodfs(adjList, i, visited, inRecursion, st))return new int[0];
            }
        }
        int [] result = new int[numCourses];
        int i=0;
        while(!st.isEmpty()){
            result[i]=st.pop();
            i++;
        }
        return result;
    }

    private static boolean courseScheduleTwodfs(Map<Integer, List<Integer>> adjList, int u, boolean[] visited, boolean[] inRecursion, Stack<Integer> st) {
        visited[u] = true;
        inRecursion[u] = true;
        if(adjList.get(u) !=null){
            for( int v :adjList.get(u)){
                if(inRecursion[v]){
                    return true;
                }
                if(!visited[v]){
                    if(courseScheduleTwodfs(adjList, v, visited, inRecursion, st))return true;
                }
            }
        }
        inRecursion[u] = false;
        st.push(u);
        return false;
    }
}
