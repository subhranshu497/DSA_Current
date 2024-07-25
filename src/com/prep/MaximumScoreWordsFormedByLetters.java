package com.prep;

import java.util.*;

public class MaximumScoreWordsFormedByLetters {
    public static  int maxScore;
    public static int[] freq;
    public static void main(String[] args) {
        String[] words={"dog", "cat", "dad", "good"};
        char[] letters={'a','a','c','d','d','d','g','o','o'};
        int[] score ={1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int maxScore=maxScoreWords(words,letters,score);
        System.out.println(maxScore);
    }

    private static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int w = words.length;
        freq = new int[26];
        //count the freq
        for(char c:letters){
            freq[c-'a']++;
        }
        maxScore =0;
        checkWords(w-1,words, score, new int[26],0);
        return maxScore;
    }

    private static void checkWords(int w, String[] words, int[] score, int[] subLetters, int totalScore) {

    }

    private static int maxScoreWordsDiscarded(String[] words, char[] letters, int[] score) {
        int[] sumOfScore = new int[words.length];
        Map<String,Integer> map = new HashMap<>();
        int i=0;
        for(String word:words){
            char[] wordArr = word.toCharArray();
            int sum =0;
            for(char ch:wordArr){
                int index = ch-97;
                int scoreOfLetter =score[index];
                sum +=scoreOfLetter;
            }
            sumOfScore[i]=sum;
            map.put(word,sum);
            i++;
        }
        Map<String, Integer> sortEdMap = sortByValue(map);
        Arrays.sort(sumOfScore);
        int result =0;
        for(Map.Entry<String, Integer> entry:sortEdMap.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            char[] keyCharArr=key.toCharArray();
            int k=0;
            int l=0;
            while(k<letters.length){
                if(letters[k]==keyCharArr[l]){
                    letters[k] ='#';
                    l++;
                }
                else k++;
            }
            if(l==key.length()) result +=value;
        }
        return result;
    }
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        // Convert the entries of the HashMap into a List
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());

        // Sort the List based on the values using a custom Comparator
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // Create a new LinkedHashMap to store the sorted entries
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
