package com.prep;

public class FindChampionII {
    public static void main(String[] args) {
        int [][] edges = {{0,2},{1,3},{1,2}};
        int n = 4;
        int champ = findChampionII(edges, n);
        System.out.println(champ);
    }

    private static int findChampionII(int[][] edges, int n) {
        int champ = -1;
        int champCount =0;
        int [] inDegree = new int[n];
        //prepare indegree array
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];

            inDegree[v]++;
        }
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                champ=i;
                champCount++;
                if(champCount>1)return -1;
            }
        }
        return champ;
    }
}
