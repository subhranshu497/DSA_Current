package com.prep;

import java.util.*;

/*
Leetcode # 399
 */
public class EvaluateDivision {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("a");
        temp.add("b");
        equations.add(temp);
        temp.remove(0);
        temp.remove(1);
        temp.add("a");
        temp.add("c");
        equations.add(temp);
        double[] values = {2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
        temp.remove(0);
        temp.remove(1);
        temp.add("a");
        temp.add("c");
        queries.add(temp);
        temp.remove(0);
        temp.remove(1);
        temp.add("a");
        temp.add("e");
        queries.add(temp);
        temp.remove(0);
        temp.remove(1);
        temp.add("b");
        temp.add("a");
        queries.add(temp);
        double[] result = calcEquation(equations, values, queries);
    }

    private static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, List<Node>> graph = createAdjacencyMartixMap(equations, values);
        for(int i=0;i<queries.size();i++){
            result[i] = evaluateDivisionDFS(queries.get(i).get(0),queries.get(i).get(1), new HashSet<>(),graph);
        }

        return result;
    }

    private static double evaluateDivisionDFS(String src, String dest, Set<String> visited, Map<String, List<Node>> graph) {
        if(!(graph.containsKey(src) && graph.containsKey(dest))) return -1.0;
        if(src.equals(dest)) return 1.0;
        visited.add(src);
        for(Node ng: graph.get(src)){
            if(!visited.contains(ng.key)){
                double ans = evaluateDivisionDFS(ng.key,dest, visited, graph);
                if(ans != -1.0) return ans * ng.val;
            }
        }
        return -1.0;
    }

    private static Map<String, List<Node>> createAdjacencyMartixMap(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> g = new HashMap<>();
        for(int i=0;i<values.length;i++){
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            g.putIfAbsent(src, new ArrayList<>());
            g.putIfAbsent(dest, new ArrayList<>());
            g.get(src).add(new Node(dest, values[i]));
            g.get(dest).add(new Node(src, 1/values[i]));
        }
        return g;
    }
}

class Node{
    String key;
    double val;
    public Node(String dest, double value){}
    public Node(String key, int val){
        this.key = key;
        this.val = val;
    }
}
