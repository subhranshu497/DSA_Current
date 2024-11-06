package com.prep;

import java.util.HashSet;
import java.util.Set;

public class SplitaStringIntoTheMaxNumberOfUniqueSubstrings {
    public static void main(String[] args) {
        String s = "ababccc";
        int count = maxUniqueSplit(s);
        System.out.println(count);
    }

    private static int maxUniqueSplit(String s) {
        return solveMaxUniqueSplit(s, new HashSet<String>());
    }

    private static int solveMaxUniqueSplit(String s, Set<String> seen) {
        int max = 0;
        for(int i=1;i<=s.length();i++){
            String sub = s.substring(0,i);
            if(!seen.contains(sub)){
                //do backtrack
                seen.add(sub);
                max = Math.max(max, 1+solveMaxUniqueSplit(s.substring(i),seen));
                seen.remove(sub);
            }
        }
        return max;
    }
}
