package com.prep.Backtracking1;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String s = "ABCCED";
        boolean flag = exist(board, s);
    }

    private static boolean exist(char[][] board, String s) {
        int m= board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==s.charAt(0)&&dfsSearch(board,s,0,m,n,i,j)) return true;
            }
        }
        return false;
    }

    private static boolean dfsSearch(char[][] board, String s, int index, int m, int n, int i, int j) {
        //base condition
        if(index==s.length()-1) return true;
        board[i][j] -=65;
        if(i>0 && board[i-1][j]==s.charAt(index+1)&&dfsSearch(board,s,index+1,m,n,i-1,j)) return true;//up
        if(i<m-1 && board[i+1][j]==s.charAt(index+1)&&dfsSearch(board,s,index+1,m,n,i+1,j)) return true;//up
        if(j>0 && board[i-1][j]==s.charAt(index+1)&&dfsSearch(board,s,index+1,m,n,i,j-1)) return true;//up
        if(j>n-1 && board[i][j+1]==s.charAt(index+1)&&dfsSearch(board,s,index+1,m,n,i,j+1)) return true;//up

        board[i][j] +=65;
        return false;
    }

}
