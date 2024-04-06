package com.prep.hackerRank.RecursionBackTracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath", "pea","eat","rain"};
        List<String> result = findWords(board,words);
        System.out.println(result);
    }

    private static List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n=board[0].length;
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for(String word:words){
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]==word.charAt(0) && dfswordII(board,word,0,i,j,m,n, visited)){
                        result.add(word);
                    }
                }
            }
        }
        return result;
    }

    private static boolean dfswordII(char[][] board, String word, int index, int i, int j, int m, int n, boolean[][] visited) {
        if(index==word.length()-1)return true;
        visited[i][j] =true;
        if(i<m && !visited[i+1][j] && board[i+1][j]== word.charAt(index+1) && dfswordII(board,word,index+1,i+1,j,m,n,visited)) return true;
        if(j<n && !visited[i][j+1] && board[i][j+1]== word.charAt(index+1) && dfswordII(board,word,index+1,i,j+1,m,n,visited)) return true;
        if(i>0 && !visited[i-1][j] && board[i-1][j]== word.charAt(index+1) && dfswordII(board,word,index+1,i-1,j,m,n,visited)) return true;
        if(j>0 && !visited[i][j-1] && board[i][j-1]== word.charAt(index+1) && dfswordII(board,word,index+1,i,j-1,m,n,visited)) return true;
        visited[i][j] = false;
        return false;
    }
}
