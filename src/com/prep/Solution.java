package com.prep;

public class Solution {
    public static void main(String[] args) {
        int [][] G= {{0,0,1},{1,0,1}};
        int R =2;
        int C =3;
        double r = getHitProbability(R,C, G);
        System.out.println(r);
    }

    private static double getHitProbability(int R, int C, int[][] G) {
        double result=0.0;
        int countShip = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(G[i][j]==1)countShip++;
            }
        }
        System.out.println(countShip);
        result =(double) countShip/(R*C);
        return result;
    }
}
