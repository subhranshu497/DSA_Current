package com.prep;

public class RotateString {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "abced";
        System.out.println(rotateString(s,goal));
    }

    private static boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s+s).contains(goal)?true:false;
    }
}
