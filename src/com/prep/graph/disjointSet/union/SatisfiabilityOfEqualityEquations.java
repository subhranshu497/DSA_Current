package com.prep.graph.disjointSet.union;

public class SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        String [] equations = {"a==b", "b==a"};
        boolean flag = equationsPossible(equations);
        System.out.println(flag);
    }

    private static boolean equationsPossible(String[] equations) {
        int [] parent = new int[26];
        int [] rank = new int[26];
        //initialize parent and rank
        for(int i=0;i<26;i++){
            parent[i]=i;
            rank[i]=0;
        }
        // process elements
        for(String eq:equations){
            if(eq.charAt(1)=='='){
                //do union
                union(eq.charAt(0)-'a',eq.charAt(3)-'a',parent, rank);
            }
        }
        //process element for !=
        for(String eq : equations){
            if(eq.charAt(1) == '!'){
                int fp = find(eq.charAt(0)-'a', parent);
                int sp = find(eq.charAt(3)-'a', parent);
                if(fp==sp) return false;
            }
        }
        return true;
    }
    //find method using path compression
    private static int find(int x, int[] parent){
        if(x == parent[x]) return x;
        return parent[x]=find(parent[x], parent);
    }
    //union by rank
    private static void union(int x, int y, int [] parent, int [] rank){
        int xp = find(x, parent);
        int yp = find(y, parent);
        if(xp == yp) return;
        if(rank[xp]>rank[yp]) parent[yp]=xp;
        else if(rank[xp] < rank[yp]) parent[xp] = yp;
        else{
            parent[xp] = yp;
            parent[yp]++;
        }
    }
}
