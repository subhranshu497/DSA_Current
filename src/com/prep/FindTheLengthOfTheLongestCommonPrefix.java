package com.prep;

import java.util.HashSet;
import java.util.Set;

public class FindTheLengthOfTheLongestCommonPrefix {
    public static void main(String[] args) {
        int [] arr1 = {1,10,100};
        int [] arr2 = {1000};
        int len = longestCommonPrefix(arr1, arr2);
        System.out.println(len);
    }

    private static int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for(int num:arr1){
         while(num >0){
             set.add(num);
             num /=10;
         }
        }
        int result =0;
        for(int num:arr2){
            while (num >0){
                if(set.contains(num)){
                    int len = (num+"").length();
                    result = Math.max(result, len);
                }
                num /=10;
            }
        }
        return result;
    }
}
