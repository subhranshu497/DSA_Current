package com.prep;

import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ConstructStringWithRepeatLimit {
    public static void main(String[] args) {
        String s = "cczazcc";
        int repeatLimit =3;
        String res = repeatLimitedString(s,repeatLimit);
        System.out.println(res);
    }

    private static String repeatLimitedString(String s, int repeatLimit) {
        int [] charArr = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            charArr[ch-'a']++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<26;i++) {
            if (charArr[i] > 0)
                pq.offer((char) ('a' + i));
        }
            while (!pq.isEmpty()) {
                char ch = pq.poll();
                int freq = Math.min(repeatLimit, charArr[ch-'a']);
                for (int i = 0; i < freq; i++) {
                    sb.append(ch);
                }
                charArr[ch-'a'] -=freq;
                if (charArr[ch-'a'] > 0 && !pq.isEmpty()) {
                    char next = pq.poll();
                    sb.append(next);
                    charArr[next-'a']--;
                    if (charArr[next-'a'] > 0)
                        pq.offer(next);
                    pq.offer(ch);
                }
            }
        return sb.toString();
    }
}
