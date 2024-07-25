package com.prep;

public class ScoreOfString {
    public static void main(String[] args) {
        String s = "zaz";
        int score =scoreOfString(s);
        System.out.println(score);
    }

    private static int scoreOfString(String s) {
        int score=0;
        for(int i=1;i<s.length();i++){
            score +=Math.abs(s.charAt(i)-s.charAt(i-1));
        }
        return score;
    }
}
