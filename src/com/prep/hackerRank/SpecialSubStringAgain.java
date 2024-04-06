package com.prep.hackerRank;

public class SpecialSubStringAgain {
    public static void main(String[] args) {
        String str = "mnonopoo";
        System.out.println(specialSub(str));
    }

    private static long specialSub(String s) {
        long count =s.length();
        for(int i=0;i<s.length();i++){
            int repeat = 0;
            while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                repeat++;
                i++;
            }
            count +=(repeat*(repeat+1))/2;
            int pointer =1;
            while(i-pointer>=0 && i+pointer<s.length() && s.charAt(i-pointer)==s.charAt(i-1) && s.charAt(i+pointer)==s.charAt(i-1)){
                count++;
                pointer++;
            }
        }
        return count;
    }
}
