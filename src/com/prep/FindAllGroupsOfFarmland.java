package com.prep;

import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsOfFarmland {
   private static List<List<Integer>> results;
    public static void main(String[] args) {
        int[][] land ={{1,0,0},{0,1,1},{0,1,1}};
        results = farmLand(land);
    }

    private static List<List<Integer>> farmLand(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        dfsLand(land,rows, cols, 0,0, new ArrayList<>());

        return results;
    }

    private static void dfsLand(int[][] land, int rows, int cols, int i, int j, List<Integer> list) {
        //base condition
//        if(i<0 || i>=rows || j<0 || j>=cols || land[i][j] !=1){
//            return;
//        }
//        if(land[i][j]==1){
//            if
//        }
    }
}
