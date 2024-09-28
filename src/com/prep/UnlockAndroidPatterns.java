package com.prep;

public class UnlockAndroidPatterns {
    public static void main(String[] args) {
        int m=1;
        int n=1;
        int pattern = numberOfPatterns(m,n);
        System.out.println(pattern);
    }

    private static int numberOfPatterns(int m, int n) {
        //keep track of jumps
        int[][] midElements = new int[10][10];
        midElements[1][3] = midElements[3][1]=2;
        midElements[1][7] = midElements[7][1]=4;
        midElements[3][9] = midElements[9][3]=6;
        midElements[7][9] = midElements[9][7]=8;
        midElements[1][9] = midElements[9][1]=midElements[2][8] = midElements[8][2]=midElements[3][7] = midElements[7][3]=
                midElements[4][6] = midElements[6][4]=5;
        boolean[] visited = new boolean[10];
        int count =0;
        for(int i=m;i<=n;i++){
            count +=patternDFS(1, i-1, visited, midElements)*4;
            count +=patternDFS(2, i-1, visited, midElements)*4;
            count +=patternDFS(5, i-1, visited, midElements);
        }
        return count;
    }

    private static int patternDFS(int curr, int rem, boolean[] visited, int[][] midElements) {
        //base condition
        if(rem <0)return 0;
        if(rem==0) return 1;
        visited[curr] = true;
        int count =0;
        for(int i=1;i<=9;i++){
            if(!visited[i] && (midElements[curr][i]==1 ||visited[midElements[curr][i]]))
                count +=patternDFS(i, rem-1,visited, midElements);
        }
        visited[curr] = false;
        return count;
    }
}
