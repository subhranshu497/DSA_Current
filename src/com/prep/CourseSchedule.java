package com.prep;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int [][] prerequisites = {{1,0}, {0,1}};
        int numCourses = 2;
        boolean flag = canFinishUsingDFS(prerequisites, numCourses);
        System.out.println(flag);
    }

    //using DFs
    private static boolean canFinishUsingDFS(int[][] prerequisites, int numCourses) {
        //create adj list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] preq:prerequisites){
            int u = preq[1];
            int v = preq[0];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i] && courseScheduleDFS(adjList, visited, i, inRecursion))return false;
        }
        return true;
    }

    private static boolean courseScheduleDFS(Map<Integer, List<Integer>> adjList, boolean[] visited, int u, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;
        List<Integer> neighbors = adjList.get(u);
        if (neighbors != null){
            for (int neighbor : neighbors) {
                if (!visited[neighbor] && courseScheduleDFS(adjList, visited, neighbor, inRecursion)) return true;
                else if (inRecursion[neighbor]) return true;
            }
    }
        inRecursion[u]=false;
        return false;
    }

    //using BFS
    private static boolean canFinish(int[][] prerequisites, int numCourses) {
        if(prerequisites.length==0) return true;
        //create adj list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] prereq : prerequisites){
            int u = prereq[1];
            int v = prereq[0];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
        }
        System.out.println(adjList);
        //create indegree array
        int[] indegree = new int[numCourses];
        for(int u=0;u<numCourses;u++){
            List<Integer> vList = adjList.get(u);
            if(vList==null)continue;
            for(int v :vList){
                indegree[v]++;
            }
        }
        //add the node in the q whose indegree is zero
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topoSort = new ArrayList<>();
        int count=0;
        for(int i=0;i< indegree.length;i++){
            if(indegree[i]==0){
                count++;
                q.add(i);
                //topoSort.add(i);
            }
        }
        while(!q.isEmpty()){
            int u = q.poll();
            List<Integer> vList = adjList.get(u);
            if(vList==null) continue;
            for(int v : vList){
                indegree[v]--;
                if(indegree[v]==0){
                    count++;
                    q.add(v);
                    //topoSort.add(v);
                }
            }
        }
        return count==numCourses?true:false;
    }
}
