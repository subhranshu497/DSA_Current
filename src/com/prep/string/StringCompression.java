package com.prep.string;

public class StringCompression {
    public static void main(String[] args) {
        char [] chars = {'a','a','b','b','c','c','c'};
        int len = compress1(chars);
        System.out.println(len);
    }

    private static int compress1(char[] chars) {
        int n = chars.length;;
        int index = 0;
        int i =0;
        while(i<n){
            char currChar = chars[i];
            int currCount= 0;
            while(i<n && currChar == chars[i]){
                currCount++;
                i++;
            }
            chars[index] = currChar;
            index++;
            //count assign
            if(currCount > 1){
                String countStr = String.valueOf(currCount);
                for (char c:countStr.toCharArray()){
                    chars[index] = c;
                    index++;
                }
            }
            //i++;
        }
        return index;
    }
}
