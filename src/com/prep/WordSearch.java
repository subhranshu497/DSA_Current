package com.prep;

public class WordSearch {
    public static void main(String[] args) {
        char [][] board ={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(existsWord(board, word));
    }

    private static boolean existsWord(char[][] board, String word) {
        int n =board[0].length;
        int m = board.length;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0) && dfsWord(board, word, 0, i,j,m,n)) return true;
            }
        }
        return false;
    }

    private static boolean dfsWord(char[][] board, String word, int index, int i, int j, int m, int n) {
        if(index == word.length()-1)return true;
        board[i][j] -=65;
        if(i<m-1 && board[i+1][j]==word.charAt(index+1)&&dfsWord(board, word, index+1, i+1,j,m,n)) return true;
        if(j<n-1 && board[i][j+1]==word.charAt(index+1)&&dfsWord(board, word, index+1, i,j+1,m,n)) return true;
        if(i>0 && board[i-1][j]==word.charAt(index+1)&&dfsWord(board, word, index+1, i-1,j,m,n)) return true;
        if(j>0 && board[i][j-1]==word.charAt(index+1)&&dfsWord(board, word, index+1, i,j-1,m,n)) return true;
        board[i][j] +=65;
        return false;
    }
}
