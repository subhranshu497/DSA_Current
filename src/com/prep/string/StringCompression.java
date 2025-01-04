package com.prep.string;

public class StringCompression {
    public static void main(String[] args) {
        char [] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int len = compress1(chars);
        System.out.println(len);
    }

    private static int compress1(char[] chars) {
        int n = chars.length;
        int j=0;
        int index =0;
        while(j< n){
            int count =0;
            char currChar = chars[j];
            while(j<n && chars[j] == currChar){
                count +=1;
                j++;
            }
            chars[index] = currChar;
            index++;
            if(count > 1){
                String countStr = String.valueOf(count);
                for(char c:countStr.toCharArray()){
                    chars[index] = c;
                    index++;
                }
            }
        }
        return index;
    }
}
