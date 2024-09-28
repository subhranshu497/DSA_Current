package com.prep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumMovesToGetPeacefulBoard {
    public static void main(String[] args) {
        int [][] rooks = {{0,0},{1,0},{1,1}};
        int moves = minMoves(rooks);
        System.out.println(moves);
    }

    private static int minMoves(int[][] rooks) {
        int moves=0;
        int n = rooks.length;
        int [] rows = new int[n];
        int [] cols = new int[n];
        for(int i=0;i<n;i++){
            rows[i] = rooks[i][0];
            cols[i] = rooks[i][1];
        }
        Arrays.sort(rows);
        Arrays.sort(cols);
        for(int i=0;i<n;i++){
            moves +=Math.abs(rows[i]-i)+Math.abs(cols[i]-i);
        }
        return moves;
    }
}

