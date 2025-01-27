package com.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleIV {
    public static void main(String[] args) {
        int numCourses = 2;
        int [][] prerequisites = {{1,0}};
        int [][] queries = {{0,1},{1,0}};
        List<Boolean> res = checkIfPrerequiesites(numCourses, prerequisites, queries);
        System.out.println(res);
    }

    private static List<Boolean> checkIfPrerequiesites(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v); // u --> v
        }

        int Q = queries.length;
        List<Boolean> result = new ArrayList<>(Q);

        for (int i = 0; i < Q; i++) {
            int u = queries[i][0]; // Source
            int v = queries[i][1]; // Destination
            boolean[] visited = new boolean[numCourses];
            result.add(dfsCourseScheduleIV(adj, u, v, visited));
        }

        return result;
    }

    private static boolean dfsCourseScheduleIV(Map<Integer, List<Integer>> map, int u, int v, boolean[] vistied) {
        vistied[u] = true;

        if(u==v) return true;
        boolean isReachable = false;
            for (int dest : map.getOrDefault(u, new ArrayList<>())) {
                if (!vistied[dest]) {
                    isReachable = isReachable || dfsCourseScheduleIV(map, dest, v, vistied);
                }
            }

        return isReachable;
    }
}
