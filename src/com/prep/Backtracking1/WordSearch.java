package com.prep.Backtracking1;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String s = "SEE";
        boolean flag = exist(board, s);
        System.out.println(flag);
    }

    private static boolean exist(char[][] board, String s) {
        int m = board.length;
        int n = board[0].length;
        int [][] directions = {{1,0}, {-1,0},{0,1},{0,-1}};
        if(m*n < 1) return false;
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j]== s.charAt(0) && sloveExist(i,j,m,n,0,board, s, directions)) return true;
            }
        }
        return false;
    }

    private static boolean sloveExist(int i, int j, int m, int n, int index, char[][] board, String s, int [][] directions) {
        //check index equal to s length , then return true. Got the word
        if(index == s.length()) return true;
        //boundary condition
        if(i < 0 || i >= m || j < 0 || j >= n ) return false;
        if(board [i][j] !=s.charAt(index)) return false;
        //start backtracking- mark vistied
        char temp = board[i][j];
        board[i][j] = '$';
            for(int [] direction : directions){
                int newi = i+direction[0];
                int newj = j+direction[1];
                if(sloveExist(newi, newj, m,n,index+1,board,s,directions)){
                    return true;
                }
            }
            board[i][j] = temp;
            return false;
    }

}
