package com.prep;

public class MaximumNumberOfPointsWithCost {
    public static void main(String[] args) {
        int [][] points = {{1,2,3},{1,5,1},{3,1,1}};
        long point= maxPoints(points);
        System.out.println(point);
    }

    private static long maxPoints(int[][] points) {
        int r = points.length;
        int c = points[0].length;
        long [] prev = new long[c];
        for(int i=0;i<c;i++){
            prev[i]= points[0][i];
        }
        for(int i=1;i<r;i++){
            long[] left = new long[c];
            long[] right = new long[c];
            left[0] = prev[0];
            //start filling left array
            for(int j=1;j<c;j++){
                left[j]=Math.max(prev[j], left[j-1]-1);
            }
            //start filling right array
            right[c-1]= prev[c-1];
            for(int j=c-2;j>=0;j--){
                right[j]=Math.max(prev[j],right[j+1]-1);
            }
            //find the max between elements of left and right and then add curr element then find max
            long[] curr = new long[c];
            for(int j=0;j<c;j++){
                curr[j] = points[i][j]+Math.max(left[j], right[j]);
            }
            prev = curr;
        }
        //find result
        long result = Long.MIN_VALUE;
        for(int j=0;j<c;j++){
            result = Math.max(result, prev[j]);
        }
        return result;
    }
}
