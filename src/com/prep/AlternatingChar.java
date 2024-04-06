package com.prep;

public class AlternatingChar {
    public static void main(String[] args) {
        String s = "AABAAB";
        System.out.println(aDeletion(s));
    }

    private static int aDeletion(String s) {
        if(s.length()==1)return 0;
        int count =0;
        int i =1;
        while(i <s.length()){
            if(s.charAt(i-1)==s.charAt(i))count++;
            i++;
        }
        return count;
    }
}
