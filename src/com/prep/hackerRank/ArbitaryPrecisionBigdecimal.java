package com.prep.hackerRank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class ArbitaryPrecisionBigdecimal {
    public static void main(String[] args) {
        String[] s = {"1","-1","0.0"};
        precisionCalculation(s);
    }

    private static void precisionCalculation(String[] s) {
        int n = s.length;
        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                BigDecimal a1 = new BigDecimal(s1);
                BigDecimal b1 = new BigDecimal(s2);
                return b1.compareTo(a1);
            }
        };
        Arrays.sort(s,0,n, customComparator);
    }
}
