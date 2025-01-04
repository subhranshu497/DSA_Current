import java.util.*;

public class TreeDiameter {
    public static void main(String[] args) {
        int [][] edges = {{0,1},{1,2},{2,3},{1,4},{4,5}};
        int diameter =treeDiameter(edges);
        System.out.println(diameter);
    }

    //stpe -1 : - find the farthest node from a random node
    //that would be one end of the diameter
    //step -2 : - calculate the farthest node from the end calculated from step 1
    private static int treeDiameter(int[][] edges) {
        //create adj list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k-> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k-> new ArrayList<>()).add(u);
        }
        int [] diameters = findFarthestNode(adj,edges.length+1,0);

        int[] diaResult = findFarthestNode(adj,edges.length+1,diameters[0]);
        return diaResult[1];
    }

    private static int[] findFarthestNode(Map<Integer, List<Integer>> adj, int n, int src) {
        // random node is 0
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(src);
        int level =0;
        visited[src] = true;
        int farthestNode = src;
        while (!q.isEmpty()){
            int size = q.size();
            while (size >0){
                int curr = q.poll();
                farthestNode = curr;
                for(int ne:adj.getOrDefault(curr, new ArrayList<>())){
                    if(!visited[ne]){
                        visited[ne] = true;
                        q.add(ne);
                    }
                }
                size--;
            }
            if(!q.isEmpty())level++;
        }
        return new int[]{farthestNode, level};
    }
}
