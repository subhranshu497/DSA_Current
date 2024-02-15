package com.prep;

import java.util.*;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }

    private static int findCircleNum(int[][] isConnected) {
        int provinceCount = 0;
        int n = isConnected.length;
        for(int i=0;i<n;i++){
            if(isConnected[i][i]==0) continue;
            provinceCount++;
            dfs(isConnected,i);
        }
        return provinceCount;
    }

    private static void dfs(int[][] isConnected, int i) {
        isConnected[i][i] =0;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1){
                isConnected[i][j] =0;
                if(isConnected[j][j]==1)dfs(isConnected,j);
            }
        }
    }
}
