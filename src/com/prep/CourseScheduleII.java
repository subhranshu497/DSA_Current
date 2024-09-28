package com.prep;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        int [][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int numCourses =4;
        int [] order = findOrderBFS(prerequisites, numCourses);
        for(int num:order) System.out.print(num+", ");
    }

    //this can be solved using Kahn's algo
    private static int[] findOrderBFS(int[][] prerequisites, int numCourses) {
        //create adj list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] edge:prerequisites){
            int u = edge[1];
            int v = edge[0];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);

        }
        return kanhsAlgo(adjList, numCourses);
    }

    private static int[] kanhsAlgo(Map<Integer, List<Integer>> adjList, int numCourses) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int count=0;
        //calculate indegree
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            List<Integer> vList = new ArrayList<>();
            if(vList !=null){
                for(int v:vList){
                    indegree[v]++;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
                result.add(i);
                count++;
            }
        }
        //iterate Q
        while(!q.isEmpty()){
            int u = q.poll();
            List<Integer> vList = adjList.get(u);
            for(int v:vList){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                    count++;
                    result.add(v);
                }
            }
        }
        int [] resArr = new int[numCourses];
        if(numCourses==count){
            for(int i=0;i<resArr.length;i++){
                resArr[i]= result.get(i);
            }
            return resArr;
        }
        else return new int[]{};
    }
}
