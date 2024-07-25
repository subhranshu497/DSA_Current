package com.prep.workday;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[] result = findOrder(numCourses, prerequisites);
        for(int num : result)System.out.print(num+", ");

    }

    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] ingree = new int[numCourses];
        int [] result = new int[numCourses];
        // create adjacency list
        for(int i =0;i< prerequisites.length;i++){
            int destination = prerequisites[i][0];
            int source = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(source, new ArrayList<>());
            lst.add(destination);
            adjList.put(source, lst);
            ingree[destination] +=1;
        }
        Queue<Integer> q= new LinkedList<>();
        //all indices with 0 indegree in the queue
        for(int i=0;i< numCourses;i++){
            if(ingree[i]==0) q.add(i);
        }
        int i = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            result[i++] = node;
            if(adjList.containsKey(node)){
                for(Integer ne:adjList.get(node)){
                    ingree[ne]--;
                    if(ingree[ne]==0)q.add(ne);
                }
            }

        }
        if(i==numCourses) return result;
        return new int[0];
    }
}
