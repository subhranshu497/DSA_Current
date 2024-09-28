package com.prep;

import java.util.HashMap;
import java.util.Map;

public class SumOfDigitsOfStringAfterConvert {
    public static void main(String[] args) {
        String s = "zbax";
        int k = 2;
        int sum = getLucky(s,k);
        System.out.println(sum);
    }

    private static int getLucky(String s, int k) {
        StringBuilder number = new StringBuilder();
        for (char x : s.toCharArray()) {
            number.append(x - 'a'+1);

        }

        // Perform the transformation `k` times
        while (k != 0) {
            int temp = 0;
            for (char x : number.toString().toCharArray()) {
                temp += x - '0';
            }
            number = new StringBuilder(String.valueOf(temp));
            k--;
        }
        return Integer.parseInt(number.toString());
    }
}
