package com.prep.hackerRank;

public class CommonChild {
    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "ABDC";
        System.out.println(findCommonChild(s1,s2));
    }

    private static int findCommonChild(String s1, String s2) {
        int len = s1.length()>s2.length()?s1.length():s2.length();
        int count=0;
        int j=0;
        for(int i=0;i<len;i++){
            if(s1.charAt(i)==s2.charAt(j)){
                count++;
                j++;
            }
        }
        return count;
    }
}
