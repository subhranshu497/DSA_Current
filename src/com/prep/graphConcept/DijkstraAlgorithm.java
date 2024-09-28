//package com.prep.graphConcept;
//
//import java.util.*;
//
//public class DijkstraAlgorithm {
//public class Dijkstra {
//
//    static class Edge {
//        int source;
//        int destination;
//        int weight;
//
//        public Edge(int source, int destination, int weight) {
//            this.source = source;
//            this.destination = destination;
//            this.weight = weight;
//        }
//    }
//
//    static class Graph {
//        int vertices;
//        LinkedList<Edge>[] adjacencyList;
//
//        Graph(int vertices) {
//            this.vertices = vertices;
//            adjacencyList = new LinkedList[vertices];
//            for (int i = 0; i < vertices; i++) {
//                adjacencyList[i] = new LinkedList<>();
//            }
//        }
//
//        public void addEdge(int source, int destination, int weight) {
//            Edge edge = new Edge(source, destination, weight);
//            adjacencyList[source].addFirst(edge); // for directed graph
//        }
//
//        public void dijkstra(int startVertex) {
//            int INF = Integer.MAX_VALUE;
//            int [] distance = new int[vertices];
//            Arrays.fill(distance,INF);
//            boolean [] visited = new boolean[vertices];
//            Queue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(w->w.weight));
//            pq.offer(new Edge(startVertex, startVertex,0));
//            while (!pq.isEmpty()){
//                Edge edge = pq.poll();
//                int u = edge.destination;
//                if(visited[u])continue;
//                visited[u] = true;
//                for(Edge e :adjacencyList[u]){
//                    int v = e.destination;
//                    int wt = e.weight;
//                    if(!visited[v] && distance[u]+wt < distance[v]){
//                        distance[v] = distance[u]+wt;
//                        pq.offer(new Edge(u,v, distance[v]));
//                    }
//                }
//
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int vertices = 6;
//        Graph graph = new Graph(vertices);
//        graph.addEdge(0, 1, 5);
//        graph.addEdge(0, 2, 3);
//        graph.addEdge(1, 3, 6);
//        graph.addEdge(1, 2, 2);
//        graph.addEdge(2, 4, 4);
//        graph.addEdge(2, 5, 2);
//        graph.addEdge(2, 3, 7);
//        graph.addEdge(3, 4, -1);
//        graph.addEdge(4, 5, -2);
//
//        graph.dijkstra(0);
//    }
//}
