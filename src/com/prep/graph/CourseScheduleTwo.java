package com.prep.graph;

import java.util.*;

public class CourseScheduleTwo {
    public static void main(String[] args) {
        int [] [] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int numCourses = 4;
        int [] result = courseScheduleTwoDFS(prerequisites, numCourses);
        for(int num:result) System.out.print(num+", ");
    }

    private static int[] courseScheduleTwoDFS(int[][] prerequisites, int numCourses) {
        //create adj list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] p:prerequisites){
            int u = p[1];
            int v = p[0];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
        }
        //check for cycle , if cycle , then return empty array
        //else return topo sort
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        //call DFs
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(courseSchTwoDFs(adjList, visited, inRecursion, st, i))
                    return new int[0];
            }
        }
        int [] result = new int[numCourses];
        int i=0;
        while (!st.isEmpty()){
            result[i]= st.pop();
            i++;
        }
        return result;
    }

    private static boolean courseSchTwoDFs(Map<Integer, List<Integer>> adjList, boolean[] visited, boolean[] inRecursion, Stack<Integer> st, int u) {
        visited[u]= true;
        inRecursion[u]=true;
        List<Integer> vList = adjList.get(u);
        if(vList !=null){
            for(int v:vList){
                if(inRecursion[v]){
                    return true;
                }
                if(!visited[v]){
                    if(courseSchTwoDFs(adjList, visited, inRecursion, st, v))
                        return true;
                }
            }
        }
        st.push(u);
        inRecursion[u]= false;
        return false;
    }
}
