package com.prep.leetcode150.graphGeneral;

import com.prep.MinimumNumberOfMovesToSeatEveryone;

import java.util.*;

public class LNum399EvaluateDivision {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("a");
        temp.add("b");
        equations.add(temp);
        temp.remove(0);
        temp.remove(0);
        temp.add("a");
        temp.add("c");
        equations.add(temp);
        double[] values = {2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
        temp.remove(0);
        temp.remove(0);
        temp.add("a");
        temp.add("c");
        queries.add(temp);
        temp.remove(0);
        temp.remove(0);
        temp.add("a");
        temp.add("e");
        queries.add(temp);
        temp.remove(0);
        temp.remove(0);
        temp.add("b");
        temp.add("a");
        queries.add(temp);
        double [] result = calcEquation1(equations, values, queries);
        for(int i=0;i< queries.size();i++) System.out.print(result[i]+" ");
    }

    //it is a problem of graph , if we will observe closely , in terms equation two vertices are given
    // value is the edge weight
    // so if a->b = 2 , then b->a = 1/2
    // create the adj list accordingly
    public static double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> adjList = new HashMap<>();
        int i=0;
        for(List<String> list: equations){
            String u = list.get(0);
            String v=list.get(1);
            double wt = values[i];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(new Pair(v, wt));
            adjList.get(v).add(new Pair(u, 1/wt));
            i++;
        }
        //iterate queries for evaluation
        //i am doing it using DFS first
        double [] result = new double[queries.size()];
        int j=0;
        for(List<String> query:queries){
            String src = query.get(0);
            String dest = query.get(1);
            double prod = 1.0;
            double[] ans = new double[]{-1.0};
            if(adjList.containsKey(src)) {
                Set<String> visited = new HashSet<>();
                evalQueriesDFS(adjList, visited, src, dest, prod,ans);
            }
            result[j++] = ans[0];
        }
        return result;
    }

    private static void evalQueriesDFS(Map<String, List<Pair>> adjList, Set<String> visited, String u, String dest, double prod, double[] ans) {
        //first rule of DFS - mark the cell visitied
        if(visited.contains(u))return;
        visited.add(u);
        if(u.equals(dest)){
            ans[0] = prod;
            return;
        }
        if(adjList.get(u) !=null){
            for(Pair p:adjList.get(u)){
                double wt = p.wt;
                String v = p.vertice;
                evalQueriesDFS(adjList, visited, v, dest, prod*wt, ans);
            }
        }
    }

    static class Pair{
        String vertice;
        double wt;
        Pair(String vertice, double wt){
            this.vertice = vertice;
            this.wt = wt;
        }
    }
}
