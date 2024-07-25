package com.prep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LuckyNumberInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        List<Integer> lucky = luckyNumber(matrix);
    }

    private static List<Integer> luckyNumber(int[][] matrix) {
        List<Integer> luckyList = new ArrayList<>();
        Set<Integer> minSet = new HashSet<>();
        Set<Integer> maxSet = new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<matrix[0].length;j++){
                min = Math.min(matrix[i][j],min);
            }
            minSet.add(min);
        }
        for(int j=0;j<matrix[0].length;j++){
            int max = Integer.MIN_VALUE;
            for(int i=0;i<matrix.length;i++){
                max = Math.max(matrix[i][j],max);
            }
            maxSet.add(max);
        }
        for(int item:minSet){
            if(maxSet.contains(item))luckyList.add(item);
        }
        return luckyList;
    }
}
