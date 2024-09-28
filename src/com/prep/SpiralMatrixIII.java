package com.prep;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixIII {
    public static void main(String[] args) {
        int rows = 5, cols = 6, rStart = 1, cStart = 4;
        int[][] result = spiralMatrixIIISolution(rows, cols, rStart, cStart);
    }

    private static int[][] spiralMatrixIIISolution(int rows, int cols, int rStart, int cStart) {
        /**
         * move follows east --> south -->west-->north -->east
         * when moving to east or west steps count increases by 1
         * moving to north and south steps count is same
         * moving to east - (x,y+1) , south - (x+1, y), west - (x, y-1) , north - (x-1, y)
         */
        int steps =0;
        List<int[]> result = new ArrayList<>();
        int [][] directions ={
                              {0,1},
                              {1,0},
                              {0,-1},
                              {-1,0}
        };
        // based on this direction array 0 - e, 1- s, 2 -w , 3-n
        int dir =0; // always move towards east at start
        while(result.size() < (rows*cols)){
            if(dir==0 || dir==2) steps++; // moving towards east or west
            for(int count =0;count<steps;count++){
                if(rStart >=0 && rStart <rows && cStart>=0 && cStart <cols){
                    result.add(new int[]{rStart, cStart});
                }
                rStart +=directions[dir][0]; // x cordinate
                cStart +=directions[dir][1]; // y cordinate
            }
            dir = (dir+1)%4;
        }
        return convertListToArray(result);
    }

    private static int[][] convertListToArray(List<int[]> result) {
        int[][] array = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            array[i] = result.get(i);
        }
        return array;
    }
}
