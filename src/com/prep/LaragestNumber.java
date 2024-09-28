package com.prep;

import java.util.Arrays;

public class LaragestNumber {
    public static void main(String[] args) {
        int [] nums = {3,30,34,5,9};
        String result = largestNumber(nums);
        System.out.println(result);
    }

    private static String largestNumber(int[] nums) {
        Integer [] numsInt = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsInt , (a,b)->{
            String s1 = Integer.toString(a);
            String s2 = Integer.toString(b);
            return (s2+s1).compareTo(s1+s2);
        });
        if(numsInt[0]==0) return "0";
        StringBuilder sb = new StringBuilder();
        for(int num:numsInt)sb.append(num);

        return sb.toString();
    }
}
