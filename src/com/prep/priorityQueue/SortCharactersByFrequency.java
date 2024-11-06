package com.prep.priorityQueue;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        String ans = frequencySort1(s);
        System.out.println(ans);
    }

    private static String frequencySort1(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char key:s.toCharArray()){
            freqMap.put(key, freqMap.getOrDefault(key, 0)+1);
        }
        //now take a priority queue - MaxHeap
        //pq should be Pair type. first - char . second - freq
        //arrange the maxheap based on the freq
        // because , char with max frequency should be poped up in the top
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.freq-a.freq);
        //write to pq
        for(Map.Entry<Character, Integer> e:freqMap.entrySet()){
            pq.add(new Pair(e.getKey(),e.getValue()));
        }
        // construct the resul string
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            Pair p = pq.peek();
            char key = p.ch;
            int value = p.freq;
            while(value > 1){
                sb.append(key);
                value--;
            }
            if(value==1){
                sb.append(key);
            }
            pq.poll();
        }
        return sb.toString();
    }
    static class Pair{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
}
