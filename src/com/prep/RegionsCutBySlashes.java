package com.prep;

public class RegionsCutBySlashes {
    public static void main(String[] args) {
        String [] grid = {"/\\","\\/"};
        int regions = regionsBySlashes(grid);
        System.out.println(regions);
    }

    private static int regionsBySlashes(String[] grid) {
        /**
         * form a 3*3 , binary matrix from slashes
         * mtrix length = grid*3
         * step-1:- for / {{0,0,1},{0,1,0},{1,0,0}} and for \ {{1,0,0},{0,1,0},{0,0,1}} and for empty space {{0,0,0},{0,0,0},{0,0,0}}
         *  place 1 based on the positions of slashes
         *  Step-2:- DO DFS and find all zeros together , count them as one region
         */
        int rows = grid.length*3;
        int cols =grid[0].length()*3;
        int[][] martix = new int[rows][cols];
        int regions=0;
        for(int i=0;i<rows/3;i++){
            for(int j=0;j<cols/3;j++){
                if(grid[i].charAt(j)=='/'){
                    martix[i*3][(j*3)+2]=1;
                    martix[(i*3)+1][(j*3)+1]=1;
                    martix[(i*3)+2][j*3]=1;
                }
                else if(grid[i].charAt(j)=='\\'){
                    martix[i*3][j*3]=1;
                    martix[(i*3)+1][(j*3)+1]=1;
                    martix[(i*3)+2][(j*3)+2]=1;
                }
            }
        }
        //step -2 do DFS
        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                if(martix[i][j]==0){
                    numberOfRegionsDFS(martix, i, j);
                    regions++;
                }
            }
        }
        return regions;
    }

    private static void numberOfRegionsDFS(int[][] martix, int i, int j) {
        //base condition
        if(i<0 || i>= martix.length || j<0 || j>=martix[0].length || martix[i][j]==1) return;
        martix[i][j]=1; // visited
        numberOfRegionsDFS(martix,i-1,j);
        numberOfRegionsDFS(martix,i+1,j);
        numberOfRegionsDFS(martix,i,j-1);
        numberOfRegionsDFS(martix,i,j+1);
    }
}
