package com.prep;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumNumberOfEqualRows {
    public static void main(String[] args) {
        int [][] matrix = {{0,1},{1,0}};
        int maxRows = maxEqualRowsAfterFlips(matrix);
        System.out.println(maxRows);
    }

    private static int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for(int [] row:matrix){
            StringBuilder sb = new StringBuilder();
            if(row[0]==1){
                for(int n:row){
                    sb.append(n==1?0:1);
                }
            }
            else{
                for(int n:row)
                    sb.append(n);
            }
            map.merge(sb.toString(),1, Integer::sum);
        }
        return Collections.max(map.values());
    }
}
