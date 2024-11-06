package com.prep;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringCompressionIII {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaabb";
        String comp = compressedString(s);
        System.out.println(comp);
    }

    private static String compressedString(String s) {
        int n = s.length();
        StringBuilder comp = new StringBuilder();
        int i=0;
        while(i<n){
            char curr = s.charAt(i);
            int count =0;
            while(i<n && s.charAt(i)==curr && count<9){
                count++;
                i++;
            }
            comp.append(count);
            comp.append(curr);
        }
        return comp.toString();
    }
}
