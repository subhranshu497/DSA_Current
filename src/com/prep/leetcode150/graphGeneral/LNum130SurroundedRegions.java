package com.prep.leetcode150.graphGeneral;

public class LNum130SurroundedRegions {
    public static void main(String[] args) {
        char [][] board ={{'X','X','X','X'},{'X','0','0','X'},{'X','X','0','X'},{'X','0','X','X'}};
        solveSurroundedRegion(board);
    }

    private static void solveSurroundedRegion(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    if(i==0 || j==0 || i==m-1  || j==n-1 ){
                        surroundedBoardDFS(board, i, j, m, n);
                    }
                }
            }
        }
        //reverse it
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }

    private static void surroundedBoardDFS(char[][] board, int i, int j, int m, int n) {
        //base condition
        if(i<0 || i>=m || j<0 || j>=n || board[i][j]=='X' || board[i][j]=='#')return;
        board[i][j] ='#';
        surroundedBoardDFS(board, i+1,j,m,n);
        surroundedBoardDFS(board, i-1,j,m,n);
        surroundedBoardDFS(board, i,j-1,m,n);
        surroundedBoardDFS(board, i,j+1,m,n);
    }
}
