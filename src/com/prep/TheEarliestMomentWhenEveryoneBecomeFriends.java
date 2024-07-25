package com.prep;

import java.util.Arrays;
import java.util.Comparator;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
    public static void main(String[] args) {
        int [][] logs = {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
        int people = 6;
        int time = earliestAcq(logs, people);
        System.out.println(time);
    }

    private static int earliestAcq(int[][] logs, int n) {
        DisjointSetUnion dsu = new DisjointSetUnion(n);
        int count=n-1;
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] log1, int[] log2) {
                Integer tsp1 = Integer.valueOf(log1[0]);
                Integer tsp2 = Integer.valueOf(log2[0]);
                return tsp1.compareTo(tsp2);
            }
        });
        for(int i=0;i<logs.length;i++){
            int p = logs[i][0];
            int x = logs[i][1];
            int y = logs[i][2];
            if(dsu.union(x,y)){
                count--;
            }
            if(count==0) return p;
        }
        return -1;
    }


}
class DisjointSetUnion{
    public static int[] rank;
    public static int[] parent;
    public int n;
    public DisjointSetUnion(int n){
        rank = new int[n];
        parent = new int[n];
        this.n =n;
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public static int findParent(int x){
        if(parent[x]!=x){
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public static boolean union(int x, int y){
        int parentX = findParent(x);
        int parentY = findParent(y);
        boolean flag = false;
        if(parentX==parentY) return flag;
        flag = true;
        if(rank[parentX]<rank[parentY]) parent[parentX]=parentY;
        else if(rank[parentX]>rank[parentY]) parent[parentY]=parentX;
        else {
            parent[parentX] = parentY;
            rank[parentY] = rank[parentY]+1;
        }
        return flag;
    }
}
