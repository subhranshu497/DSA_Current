package com.prep;

import java.util.Arrays;

public class MinimumNumberArrowsBurstBalloons {
    public static void main(String[] args) {
        int [][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(points));
    }

    private static int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int arrows = 1;
        int i=1;
        int end =points[0][1];
        while(i<points.length){
            if(points[i][0]>end){
                arrows++;
                end = points[i][1];
            }
            i++;
        }
        return arrows;
    }
}
