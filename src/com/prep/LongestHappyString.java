package com.prep;

import java.util.PriorityQueue;

public class LongestHappyString {
    public static void main(String[] args) {
        int a =1, b=1, c=7;
        String s = longestHappyString(a,b,c);
        System.out.println(s);
    }

    private static String longestHappyString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->y.first-x.first);
        if(a >0)pq.add(new Pair(a, 'a'));
        if(b >0)pq.add(new Pair(b, 'b'));
        if(c >0)pq.add(new Pair(c, 'c'));
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()){
            int currCount = pq.peek().first;
            char currChar = pq.peek().second;
            pq.poll();
            if(result.length() >=2 && result.charAt(result.length()-1)==currChar && result.charAt(result.length()-2)==currChar) {
                if (pq.isEmpty()) break;
                int next = pq.peek().first;
                char nextChar = pq.peek().second;
                pq.poll();
                result.append(nextChar);
                next--;
                if (next > 0) pq.add(new Pair(next, nextChar));
            }else {
                currCount--;
                result.append(currChar);
            }
            if(currCount > 0) pq.add(new Pair(currCount, currChar));
        }
        return result.toString();
    }
    static class Pair{
        int first;
        char second;
        Pair(int first, char second){
            this.first = first;
            this.second = second;
        }
    }
}
