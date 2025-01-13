package com.prep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueSubstringsWithEqualDigitFrequency {
    public static void main(String[] args) {
        String s = "12321";
        int count = equalDigitFrequency(s);
        System.out.println(count);
    }

    private static int equalDigitFrequency(String s) {
        Set<String> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int freq[] = new int [10];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j)-'0']++;
                int currFreq = freq[s.charAt(j)-'0'];
                boolean flag = false;
                for (int k=0;k<10;k++) {
                    if(freq[k]==0) continue;
                    if (currFreq != freq[k]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) set.add(s.substring(i,j+1));
            }
        }
        return set.size();
    }
}
